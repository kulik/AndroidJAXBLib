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
package com.kulik.android.jaxb.library.parserTest.TestDataTS;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 28.01.13
 * Time: 20:23
 */
public class DayDetail implements Serializable {

    @XmlElement(name = "DISTRIB_NBR")
    public String destribNbr;

    @XmlElement(name = "LINE_NBR")
    public Integer lineNbr;

    @XmlElement(name = "ACTIVITY")
    public String activity;

    @XmlElement(name = "ACTIVITY_ID")
    public String activityId;

    @XmlElement(name = "LINE_DETAILS")
    public String lineDetails;

    @XmlElement(name = "Hours")
    public Double hours = 0.0;

    @XmlElement(name = "START_TIME")
    public String startTime;

    @XmlElement(name = "STOP_TIME")
    public String stopTime;

    @XmlElement(name = "BREAK")
    public String breakTm;

    @XmlElement(name = "DATE_SEQ")
    public Integer dateSeq;

    @Override
    public String toString() {
        return "Activity = " + activity + " Line number = " + lineNbr + " Hours = " + hours;
    }
}
