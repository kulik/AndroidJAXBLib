package biz.kulik.android.jaxb.library.parserTest.TestDataTS;

import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import biz.kulik.android.jaxb.library.parserTest.TestData9.TSCreateRsp;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParserTS extends ParserAbstractTest<GetTSSavedResponse> {

    public void testParse9XML() {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.ts, GetTSSavedResponse.class);
    }

    @Override
    protected void assertTestData(GetTSSavedResponse ts) {
        assertNotNull(ts);
        assertNotNull(ts.tsCom);
        assertNotNull(ts.tsCom.TSDetail);
        assertTrue(ts.tsCom.TSDetail.size() == 53);
//        assertNotNull(ts.text.get(0));
//        assertEquals(ts.text.get(0), "TimeSheet1");
//        assertNotNull(ts.text.get(1));
//        assertEquals(ts.text.get(1), "TimeSheet2");
//        assertNotNull(ts.text.get(2));
//        assertEquals(ts.text.get(2), "TimeSheet3");
//        assertNotNull(ts.text.get(3));
//        assertEquals(ts.text.get(3), "TimeSheet4");
//
//        assertNotNull(ts.textS);
//        assertEquals(ts.textS, "TimeSheetString");

    }
}
