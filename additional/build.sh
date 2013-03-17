#!/bin/bash
echo "##################### Variable ##################################"
echo "hour of builds"
#Time from nightly build will be automatic tested
time=`date +%H`
if [ "$time" -le 6 ]; then
echo "true"
RUN_UNIT_TEST="true"
RUN_FUNCTIONAL_TEST="true"
fi
echo "COOL PARAMETR"
echo $RUN_UNIT_TEST
echo "COOL PARAMETR1"
echo $RUN_FUNCTIONAL_TEST
echo "BUILD_NUMBER:<b>"$BUILD_NUMBER"</b>"
#The current build number, such as "153"
echo "BUILD_ID:"$BUILD_ID
#The current build id, such as "2005-08-22_23-59-59" (YYYY-MM-DD_hh-mm-ss)
echo "JOB_NAME:"$JOB_NAME
#Name of the project of this build, such as "foo"
echo "BUILD_TAG":$BUILD_TAG
#String of "jenkins-${JOB_NAME}-${BUILD_NUMBER}". Convenient to put into a resource file, a jar file, etc for easier identification.
echo "EXECUTOR_NUMBER:"$EXECUTOR_NUMBER
#The unique number that identifies the current executor (among executors of the same machine) that's carrying out this build. This is the number you see in the "build executor status", except that the number starts from 0, not 1.
echo "NODE_NAME:"$NODE_NAME
#Name of the slave if the build is on a slave, or "master" if run on master
echo "NODE_LABELS:"$NODE_LABELS
#Whitespace-separated list of labels that the node is assigned.
echo "JAVA_HOME:"$JAVA_HOME
#If your job is configured to use a specific JDK, this variable is set to the JAVA_HOME of the specified JDK. When this variable is set, PATH is also updated to have $JAVA_HOME/bin.
echo "WORKSPACE:"$WORKSPACE
#The absolute path of the workspace.
echo "HUDSON_URL:"$HUDSON_URL
echo "HUDSON_SETTINGS: "$HUDSON_SETTINGS
#Full URL of Hudson, like http://server:port/hudson/
echo "JENKINS_URL:"$JENKINS_URL
#Full URL of Jenkins, like http://server:port/jenkins/
echo "BUILD_URL:"$BUILD_URL
#Full URL of this build, like http://server:port/jenkins/job/foo/15/
echo "JOB_URL:"$JOB_URL
#Full URL of this job, like http://server:port/jenkins/job/foo/
echo "SVN_REVISION:"$SVN_REVISION
#For Subversion-based projects, this variable contains the revision number of the module.
echo "CVS_BRANCH:"$CVS_BRANCH
#For CVS-based projects, this variable contains the branch of the module. If CVS is configured to check out the trunk, this environment variable will not be set.
echo " ########################### PRE SCRIPT ##############################" 
echo "                        * * * * * $1 $2 $3 $4 * * * * *" 

cd $WORKSPACE
cp $HUDSON_SETTINGS/local.properties Test
cp $HUDSON_SETTINGS/local.properties .

cd Test

echo " ########################### BUILD SCRIPT ##############################" 
echo "uninstall biz.kulik.android.jaxb.library"	
adb uninstall biz.kulik.android.jaxb.library

echo " ###################### MAKE UNIT TESTS ########################" 

ant clean
ant emma debug install 
	
echo "***START LOG"
adb logcat -v time> ./report/log_unit.log &

ant emma test
	
echo "***sleep process"
sleep 10

echo "***kill log writer process"
kill $!

echo "***sleep process"
sleep 10
	
 	#echo "$base/logtoHTML.sh"
	#cat log.log | $base/logtoHTML.sh  >log.html 
$WORKSPACE/additional/logtoHTML.sh < ./report/log_unit.log > ./report/log_unit.html 
echo "***FINISH LOG"
