package biz.kulik.android.jaxb.library.parserTest.TS_Roster;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import biz.kulik.android.jaxb.library.parserTest.TestLongData4.RootBusStop;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestTS_Roster extends AndroidTestCase {
    private static final String TAG = TestTS_Roster.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testParse4XML() {
        InputStream inputStream = getContext().getResources().openRawResource(R.raw.ts_roster_xml);

        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);

        GetRosterResponse lbs;
        lbs = parser.parse(GetRosterResponse.class, inputStream);

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
