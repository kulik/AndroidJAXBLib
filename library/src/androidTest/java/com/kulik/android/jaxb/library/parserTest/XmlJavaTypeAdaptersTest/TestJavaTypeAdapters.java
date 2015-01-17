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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import com.kulik.android.jaxb.library.test.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters extends ParserAbstractTest<MyBean> {

    public void testParseJavaTypeAdaptersJSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_java_type_adapters_json, MyBean.class);
    }

    public void testParseJavaTypeAdaptersXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_java_type_adapters_xml, MyBean.class);
    }


    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    protected void assertTestData(MyBean ts) {
        assertNotNull(ts);
        assertNotNull(ts.myDate);

        try {
            assertEquals(ts.myDate, dateFormat.parse("12.12.1988"));
        } catch (ParseException e) {
            assertTrue(e.getMessage(), false);
        }
        //TODO make more assertations

    }
}
