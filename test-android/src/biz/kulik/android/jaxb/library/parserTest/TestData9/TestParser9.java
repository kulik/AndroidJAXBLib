package biz.kulik.android.jaxb.library.parserTest.TestData9;

import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser9 extends ParserAbstractTest<TSCreateRsp> {

    public void testParse9JSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_9_json, TSCreateRsp.class);
    }

    public void testParse9XML() {
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
