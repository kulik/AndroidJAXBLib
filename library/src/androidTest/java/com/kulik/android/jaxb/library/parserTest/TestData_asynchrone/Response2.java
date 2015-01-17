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
package com.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Response2 {
    public static class Response {
        @XmlElement(name = "data")
        SearchSettingsResponse mSearchSettings;
    }

    public static class SearchSettingsResponse {
        @XmlElement(name = "minPrices")
        public List<ValueInt> priceMinList;

        @XmlElement(name = "maxPrices")
        public List<ValueInt> priceMaxList;

        @XmlElement(name = "minRoomSizes")
        public List<ValueInt> squareMinList;

        @XmlElement(name = "maxRoomSizes")
        public List<ValueInt> squareMaxList;

        @XmlElement(name = "minBedrooms")
        public List<ValueInt> bedroomMinList;

        @XmlElement(name = "propertyType")
        public List<ValueInt> apartmentTypeList;

        @XmlElement(name = "categorySearch")
        public List<Category> categoryList;
    }

    public static class ValueInt implements Value<Integer> {
        @XmlElement(name = "value")
        private final Integer mValue;

        @XmlElement(name = "showas")
        private final String mShowAs;

        public ValueInt() {
            this(0, "");
        }

        public ValueInt(int value, String showAs) {
            mValue = value;
            mShowAs = showAs;
        }

        @Override
        public Integer getValue() {
            return mValue;
        }

        @Override
        public String getName() {
            return mShowAs;
        }

    }

    public class Category implements Value<String> {
        @XmlElement(name = "value")
        private final String mValue;

        @XmlElement(name = "showas")
        private String mShowAs;

        public Category() {
            mValue = "";
            mShowAs = "";
        }

        @Override
        public String getValue() {
            return mValue;
        }

        @Override
        public String getName() {
            return mShowAs;
        }

        public void setName(String name) {
            mShowAs = name;
        }
    }

}
