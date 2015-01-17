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
package com.kulik.android.jaxb.library.parserTest.TestData3;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 11/6/12
 * Time: 3:20 PM
 */

//@XmlRootElement(name = "ViewingTime")
public class ViewingTime {

    @XmlElement(name = "ordering")
    private int ordering;

    @XmlElement(name = "fromTime")
    //@XmlJavaTypeAdapter(DateTimeAdapter.class) Data
    private String fromTime;

    @XmlElement(name = "toTime")
    //@XmlJavaTypeAdapter(DateTimeAdapter.class) Data
    private String toTime;
}