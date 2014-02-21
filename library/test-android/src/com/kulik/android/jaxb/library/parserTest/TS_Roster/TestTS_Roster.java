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
