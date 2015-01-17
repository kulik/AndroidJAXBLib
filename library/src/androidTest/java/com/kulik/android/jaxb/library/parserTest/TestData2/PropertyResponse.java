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
package com.kulik.android.jaxb.library.parserTest.TestData2;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
//@XmlRootElement(name = "properties")
public class PropertyResponse {

    @XmlElement(name = "adid")
    public Integer adID;

    @XmlElement(name = "mainImageUrl")
    public String mainImageUrl;

    @XmlElement(name = "priceSuggestion")
    public Integer priceSuggestion;

    @XmlElement(name = "address")
    public String address;

    @XmlElement(name = "postcode")
    public String postCode;

    @XmlElement(name = "location")
    public String location;

    @XmlElement(name = "sold")
    public Boolean sold;

}
