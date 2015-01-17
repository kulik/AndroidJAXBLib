/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.parserTest.TestData5;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:55
 */
public class WoCollection implements Serializable {

    private static final String TAG = WoCollection.class.getSimpleName();

    @XmlElement(name = "BUSINESS_UNIT")
    private String businessUnit;

    @XmlElement(name = "WORK_ORDER_ID")
    private String workOrderID;

    @XmlElement(name = "JOB_TITLE")
    private String jobTitle;

    @XmlElement(name = "USE_CLOCK")
    private String useClock;


    @XmlElement(name = "DistribCollection")
    private List<DistribCollection> destributionCollection;


    @XmlElement(name = "ActivityCollection")
    private List<ActivityCollection> activityCollection;


    public String getBusinessUnit() {
        return businessUnit;
    }

    public String getWorkOrderID() {
        return workOrderID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getUseClock() {
        return useClock;
    }

    public List<DistribCollection> getDestributionCollection() {
        return destributionCollection;
    }

    public List<ActivityCollection> getActivityCollection() {
        return activityCollection;
    }
}