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

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestParser1 extends ParserAbstractTest<SearchSuggestion> {
    private static final String TAG = TestParser1.class.getSimpleName();

    public void testParse1JSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_1_json, SearchSuggestion.class);
    }

    public void testParse1XML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_1_xml, SearchSuggestion.class);
    }

    @Override
    protected void assertTestData(SearchSuggestion se) {
        assertNotNull("", se);
        assertNotNull("", se.section);
        assertNotNull("", se.section.item);
        assertTrue("", se.section.item.size() == 3);
        assertNotNull("", se.section.item.get(0).image);
        assertNotNull("", se.section.item.get(0).image.source);
        assertNotNull("", se.section.item.get(0).title);
        assertNotNull("", se.section.item.get(0).url);

        assertNotNull("", se.section.item.get(1).image);
        assertNotNull("", se.section.item.get(1).image.source);
        assertNotNull("", se.section.item.get(1).title);
        assertNotNull("", se.section.item.get(1).url);

        assertNotNull("", se.section.item.get(2).image);
        assertNotNull("", se.section.item.get(2).image.source);
        assertNotNull("", se.section.item.get(2).title);
        assertNotNull("", se.section.item.get(2).url);

        assertEquals("", se.section.item.get(0).url, "http://en.wikipedia.org/wiki/Sun");
        assertEquals("", se.section.item.get(0).title, "Sun1");
        assertEquals("", se.section.item.get(0).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg");

        assertEquals("", se.section.item.get(1).url, "http://en.wikipedia.org/wiki/Sun1111");
        assertEquals("", se.section.item.get(1).title, "Sun2");
        assertEquals("", se.section.item.get(1).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_1%2C_2010.jpg");

        assertEquals("", se.section.item.get(2).url, "http://en.wikipedia.org/wiki/Sun2222");
        assertEquals("", se.section.item.get(2).title, "Sun3");
        assertEquals("", se.section.item.get(2).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/August_1%2C_2010.jpg");
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
