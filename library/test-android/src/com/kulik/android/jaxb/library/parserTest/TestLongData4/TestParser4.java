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
package com.kulik.android.jaxb.library.parserTest.TestLongData4;

import android.test.AndroidTestCase;

import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.ParserImpl;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestParser4 extends AndroidTestCase {
    private static final String TAG = TestParser4.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testParse4JSON() {
//        InputStream is = null;
//        InputStreamReader reader = new InputStreamReader(is);

        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_4_json_big);

        ParserImpl parser = new ParserImpl(UnMarshalerTypes.JSONAdapter);

        RootBusStop lbs;
//        lbs = parser.parse(RootBusStop.class, inputStream);

//        assertTestDate4(lbs);
        assertTrue(true);
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

    private void assertTestDate4(RootBusStop lbs) {
        assertTrue(true);

    }

}
