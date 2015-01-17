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

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class SearchSuggestion {

    @XmlElement(name = "Section")
    public Section section;

    public static class Section {
        @XmlElement(name = "Item")
        public List<Item> item;

        public static class Item {

            @XmlElement(name = "Text")
            public String title;
            @XmlElement(name = "Image")
            public Image image;
            @XmlElement(name = "Url")
            public String url;

            public static class Image {

                @XmlAttribute(name = "source")
                public String source = "";
            }
        }
    }
}
