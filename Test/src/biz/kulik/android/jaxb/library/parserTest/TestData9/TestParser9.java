package biz.kulik.android.jaxb.library.parserTest.TestData9;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.Parser;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import biz.kulik.android.jaxb.library.parserTest.TestData6.AbstractResponse;
import biz.kulik.android.jaxb.library.parserTest.TestData6.ParseCreateTSWeekResponse;

import java.io.InputStream;
import java.util.List;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser9 extends AndroidTestCase {
    private static final String TAG = TestParser9.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParse9JSON() {

        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_9_json);
    }

    public void testParse9XML() {

        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_9_xml);
    }

    private void parse(UnMarshalerTypes type, int resID) {
        InputStream inputStream = getContext().getResources().openRawResource(resID);

        ParserImpl parser = new ParserImpl(type);
        TSCreateRsp ts;
        ts = parser.parse(TSCreateRsp.class, inputStream);

        assertTestDate9(ts);
    }

    private void assertTestDate9( TSCreateRsp ts) {

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
