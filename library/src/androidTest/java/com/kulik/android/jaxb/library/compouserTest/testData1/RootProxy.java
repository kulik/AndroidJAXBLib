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
package com.kulik.android.jaxb.library.compouserTest.testData1;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import com.kulik.android.jaxb.library.Annotations.XmlRootElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:40 PM
 */
@XmlRootElement(name = "RootMe")
public class RootProxy {

    @XmlElement(name = "B")
    BProxy mb = new BProxy();

    @XmlElement(name = "A")
    AProxy ma = new AProxy();

    @XmlElement(name = "TestList1")
    @XmlElementWrapper(name = "bookList")
    List<TestListItem> mlist1 = new ArrayList<TestListItem>(Arrays.asList(new TestListItem[]{new TestListItem(1224), new TestListItem(1234)}));

    @XmlElement(name = "TestList")
    List<TestListItem> mlist = new ArrayList<TestListItem>(Arrays.asList(new TestListItem[]{new TestListItem(122), new TestListItem(123)}));

    @XmlElement(name = "TestIntegerValue")
    Integer mTestIntegerVal = Integer.valueOf(12212);

    @XmlElement(name = "TestNull")
    String mTestNull = null;

    @XmlElement(name = "TestNullList")
    List<TestListItem> mNullList = null;

    @XmlElement(name = "TestNullObj")
    Object mNullObj = null;

//        @XmlElement(name = "TestNullNillableObj", nillable = true)
//        Object mNullObjnilable = null;
//
//        @XmlElement(name = "TestNullObj1", defaultValue = "14", required = true)
//        Integer mNullObj1 = null;

    @XmlAttribute(name = "classicType")
    int classicType = 10;

    public static class TestListItem {
        @XmlElement(name = "item_value")
        Integer mItval;

        TestListItem(int val) {
            mItval = Integer.valueOf(val);
        }
    }

    public static class BProxy {
    }

    public static class AProxy {
    }

}