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
package com.kulik.android.jaxb.library.parserTest.TestWrappedData;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

import java.util.List;

/**
 * User: kulik
 * Date: 5/29/13
 * Time: 9:15 AM
 */
public class WrappedRecursiveLists {
    @XmlElementWrapper(name = "level1s")
    @XmlElement(name = "level1")
    public List<Level1> level1List;

    public static class Level1 {
        @XmlElementWrapper(name = "level2s")
        @XmlElement(name = "level2")
        public List<Level2> level2List;

        public static class Level2 {
            @XmlElementWrapper(name = "level3s")
            @XmlElement(name = "level3")
            public List<Level3> level3List;

            public static class Level3 {
                @XmlElement(name = "stringElement")
                public String stringElem;

                @XmlAttribute(name = "stringAttr")
                public String stringAttr;
            }
        }
    }
}
