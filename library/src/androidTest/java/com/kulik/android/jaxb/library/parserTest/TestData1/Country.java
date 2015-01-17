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
package com.kulik.android.jaxb.library.parserTest.TestData1;

import android.util.Log;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 11:46 AM
 */
public class Country {
    private static final String TAG = Country.class.getSimpleName();
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "City")
    private List<City> cities;

    public Country() {
        Log.v(TAG, "Country constructor");
        title = "";
    }

    public static class City {
        private static final String TAG = City.class.getSimpleName();
        @XmlElement(name = "Title")
        private String title;
        @XmlElement(name = "Description")
        private String description;

        public City() {
            Log.v(TAG, "City constructor");
            title = "";
            description = "";
        }
    }
}
