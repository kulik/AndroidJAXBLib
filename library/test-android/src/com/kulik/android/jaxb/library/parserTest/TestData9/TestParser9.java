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
package com.kulik.android.jaxb.library.parserTest.TestData9;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser9 extends ParserAbstractTest<TSCreateRsp> {

    public void testParse9JSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_9_json, TSCreateRsp.class);
    }

    public void testParse9XML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_9_xml, TSCreateRsp.class);
    }

    @Override
    protected void assertTestData(TSCreateRsp ts) {
        assertNotNull(ts);
        assertNotNull(ts.text);
        assertTrue(ts.text.size() == 4);
        assertNotNull(ts.text.get(0));
        assertEquals(ts.text.get(0), "TimeSheet1");
        assertNotNull(ts.text.get(1));
        assertEquals(ts.text.get(1), "TimeSheet2");
        assertNotNull(ts.text.get(2));
        assertEquals(ts.text.get(2), "TimeSheet3");
        assertNotNull(ts.text.get(3));
        assertEquals(ts.text.get(3), "TimeSheet4");

        assertNotNull(ts.textS);
        assertEquals(ts.textS, "TimeSheetString");

    }
}
