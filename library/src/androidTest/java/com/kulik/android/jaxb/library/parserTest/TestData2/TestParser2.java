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
package com.kulik.android.jaxb.library.parserTest.TestData2;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import com.kulik.android.jaxb.library.test.R;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser2 extends ParserAbstractTest<TestStorage> {
    private static final String TAG = TestParser2.class.getSimpleName();

    public void testParse2JSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_2_json, TestStorage.class);
    }

    //TODO implement XML
    public void testParse2XML() {

//       InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_2_xml);
//
//        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);
//
//        TestStorage ts;
//        ts = parser.parse(TestStorage.class, inputStream);
//        assertTestDate2(ts);
    }

    @Override
    public void assertTestData(TestStorage ts) {

        assertNotNull("", ts);
        assertNotNull("", ts.mFavoritePropertyResponses);
        assertTrue("", ts.mFavoritePropertyResponses.size() == 2);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0));
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).favoritedByFriend);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).favoritedByUser);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.address);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.adID);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.location);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.mainImageUrl);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.postCode);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.priceSuggestion);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).property.sold);
        assertNotNull("", ts.mFavoritePropertyResponses.get(0).rate);

        assertNotNull("", ts.mFavoritePropertyResponses.get(1));
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).favoritedByFriend);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).favoritedByUser);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.address);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.adID);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.location);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.mainImageUrl);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.postCode);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.priceSuggestion);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).property.sold);
        assertNotNull("", ts.mFavoritePropertyResponses.get(1).rate);


        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.address, "Gullagata 27 A");
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.adID, Integer.valueOf(37827466));
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.location, "Hønefoss");
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.mainImageUrl, "http://finncdn.no/mmo/2012/10/vertical-2/17/6/378/274/66_1520550395.jpg");
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.postCode, "3513");
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.priceSuggestion, Integer.valueOf(2450000));
        assertEquals("", ts.mFavoritePropertyResponses.get(0).property.sold, Boolean.valueOf(false));
        assertEquals("", ts.mFavoritePropertyResponses.get(0).rate, Integer.valueOf(4));

        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.address, "Bjørneveien 14 B");
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.adID, Integer.valueOf(37827294));
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.location, "Kongsberg");
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.mainImageUrl, "http://finncdn.no/mmo/2012/10/vertical-2/17/4/378/272/94_2108968499.jpg");
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.postCode, "3617");
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.priceSuggestion, Integer.valueOf(1200000));
        assertEquals("", ts.mFavoritePropertyResponses.get(1).property.sold, Boolean.valueOf(false));
        assertEquals("", ts.mFavoritePropertyResponses.get(1).rate, Integer.valueOf(4));
    }

}
