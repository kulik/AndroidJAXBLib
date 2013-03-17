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
name=$1_$2_RC32.apk
self="${0#./}"
base="${self%/*}"
sources=$WORKSPACE/Merchant

echo $base
cd $WORKSPACE
cp $HUDSON_SETTINGS/local.properties Test
cp $HUDSON_SETTINGS/local.properties .

echo " ########################### BUILD SCRIPT ##############################" 
echo "uninstall biz.kulik.android.jaxb.library"	
adb -s emulator-5556 uninstall com.creator

echo " ###################### MAKE UNIT TESTS ########################" 

ant clean
ant emma debug install 
	
echo "***START LOG"
adb -s emulator-5556 logcat -v time> ./report/log_unit.log &

ant test
	
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

	echo "*** Copy butafore test reports"
	cd $WORKSPACE/CreatorTest
	mkdir -p bin
	mkdir -p report
	cp $WORKSPACE/BuildScripts/default_log_unit.html $WORKSPACE/CreatorTest/report/log_unit.html 
	cd bin
	mkdir -p reports
	cp $WORKSPACE/BuildScripts/default_junit_report.xml $WORKSPACE/CreatorTest/bin/reports/junit-report.xml 
fi
#if [ "$3" = "test" ]; then
#	echo " ########################### TEST SCRIPT ##############################" 
#	cd $WORKSPACE/CreatorTest
#	  
#	ant uninstall
#	#ant debug
#	ant installr
#	ant test
#fi
#if [ "$4" = "func-test" ]; then
if [ "$RUN_FUNCTIONAL_TEST" = "true" ]; 
then
	echo " ###################### FUNCTIONAL TEST SCRIPT ########################" 

	cd $WORKSPACE
	rm -rf testapk
	mkdir -p testapk
		
       echo "prepare target app"
	if [ $1 = "merchant" ]; then
	  cp sources/build_settings/CreatorManifest.xml $WORKSPACE/sources/AndroidManifest.xml
	fi
	
	cd sources 	
	ant clean
	ant release
	
	echo "cp "$WORKSPACE/"sources/bin/"$1"-release.apk  "$WORKSPACE"/testapk/"$name
	cp $WORKSPACE/sources/bin/$1-release.apk  $WORKSPACE/testapk/$name

	cd $WORKSPACE/CreatorFunctionalTests
	sed -i -e 's/Creator_stable/sources/i' "ant.properties" 
	
	echo "ant clean"
	ant clean
	echo "ant instrument"
	ant instrument
	
	echo "prepare to release"
	sed -i -e 's/<!--<classpathentry kind="lib" path="libs/emma.jar"/>-->/<classpathentry kind="lib" path="libs/emma.jar"/>/i' ".classpath" 
	cp $WORKSPACE/BuildScripts/emma.jar  $WORKSPACE/CreatorFunctionalTests/libs
	cp $WORKSPACE/BuildScripts/emma_ant.jar  $WORKSPACE/CreatorFunctionalTests/libs
	ant clean
	ant release

	cp bin/$1-functional-test-release.apk $WORKSPACE/testapk && echo "cp bin/"$1"-functional-test-release.apk "$WORKSPACE"/testapk"
	
	cd $WORKSPACE

	echo "uninstall com.creator.test - functional test"
	adb -s emulator-5556 uninstall com.creator.test 
	
	echo "uninstall com.adscreator"
	adb -s emulator-5556 uninstall com.adscreator
	
	echo "uninstall com.adscreator.test"
	adb -s emulator-5556 uninstall com.adscreator.test

	echo "install com.adscreator"
	adb -s emulator-5556 install testapk/$name

	echo "install com.creator.test -functional test"
	adb -s emulator-5556 install testapk/$1-functional-test-release.apk 

#	adb -s emulator-5556 shell am instrument -w com.adscreator.test/com.zutubi.android.junitreport.JUnitReportTestRunner
	cd $WORKSPACE/CreatorFunctionalTests 
	
	echo " ###################### MAKE FUNCTIONAL TESTS ########################" 
	echo "***START LOG"
	adb -s emulator-5556 logcat -v time> ./report/log_func.log &
	ant emma test
	
	echo "***sleep process"
 	sleep 10

	echo "***kill log writer process"
 	kill $!

	echo "***sleep process"
 	sleep 10
	
	#echo $base/logtoHTML.sh
	#cat log.log | $base/logtoHTML.sh  >log.html 
	$WORKSPACE/BuildScripts/logtoHTML.sh < ./report/log_func.log > ./report/log_func.html 
	echo "***FINISH LOG"
#else
#	if [ $2 = "dev" ]; then
#		echo "*** Copy butafore test reports"
#		cd $WORKSPACE/CreatorFunctionalTests
#		cp $WORKSPACE/BuildScripts/default_coverage.xml $WORKSPACE/CreatorFunctionalTests/coverage.xml 
#		mkdir -p report
#		cp $WORKSPACE/BuildScripts/default_log_func.html $WORKSPACE/CreatorFunctionalTests/report/log_func.html 
#	fi
fi
