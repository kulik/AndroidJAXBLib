package biz.kulik.android.jaxb.library.parserTest.TestData2;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.AdapterTypes;
import biz.kulik.android.jaxb.library.parser.ParserImpl;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser2 extends AndroidTestCase {
    private static final String TAG = TestParser2.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParse2JSON() {

        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_2_json);

        ParserImpl parser = new ParserImpl(AdapterTypes.JSONAdapter);

        TestStorage ts;
        ts = parser.parse(TestStorage.class, inputStream);
        assertTestDate2(ts);
    }

    //TODO implement XML
    public void testParse2XML() {

//       InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_2_xml);
//
//        ParserImpl parser = new ParserImpl(AdapterTypes.XMLAdapter);
//
//        TestStorage ts;
//        ts = parser.parse(TestStorage.class, inputStream);
//        assertTestDate2(ts);
    }

    private void assertTestDate2(TestStorage ts) {

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
