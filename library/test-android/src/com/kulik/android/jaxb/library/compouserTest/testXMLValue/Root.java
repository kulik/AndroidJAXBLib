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
package com.kulik.android.jaxb.library.compouserTest.testXMLValue;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import com.kulik.android.jaxb.library.Annotations.XmlRootElement;
import com.kulik.android.jaxb.library.Annotations.XmlValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:40 PM
 */
@XmlRootElement(name = "RootMe")
public class Root {

    @XmlElement(name = "A")
    AProxy ma = new AProxy();

    @XmlElement(name = "B")
    BProxy mb = new BProxy("aaa", "classaaa");

    @XmlElement(name = "TestList1")
    @XmlElementWrapper(name = "bookList")
    List<BProxy> mlist1 = new ArrayList<BProxy>(Arrays.asList(new BProxy[]{new BProxy("asda1", "Class10"), new BProxy("asda2", "Class20"), new BProxy("asda3", "Class30")}));

    @XmlElement(name = "TestNull")
    BProxy mTestNull = new BProxy("asda", null);

    public static class BProxy {
        @XmlAttribute(name = "classicType")
        String attr;

        @XmlValue
        String value;

        public BProxy(String attr, String value) {
            this.attr = attr;
            this.value = value;
        }
    }

    public static class AProxy {
        @XmlValue
        String value = "aProxyValue";

    }

}