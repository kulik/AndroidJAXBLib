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
package com.kulik.android.jaxb.library.parserTest.TS_Roster;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestTS_Roster extends ParserAbstractTest<GetRosterResponse> {
    private static final String TAG = TestTS_Roster.class.getSimpleName();

    public void testParse4XML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.ts_roster_xml, GetRosterResponse.class);
    }

//    public void testParse4XML() {
//        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_1_xml.xml);
//
//        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);
//
//        BusStops se;
//        se = parser.parse(BusStops.class, inputStream);
//
//        assertTestDate4(lbs);
//    }

    @Override
    protected void assertTestData(GetRosterResponse ts) {
        assertTrue(true);
    }
}
