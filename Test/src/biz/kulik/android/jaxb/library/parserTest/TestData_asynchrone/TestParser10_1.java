package biz.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser10_1 extends ParserAbstractTest<Response1> {
    //TODO implement asynchronus test
    public void testParse10JSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_10_1_json, Response1.class);
    }

    @Override
    protected void assertTestData(Response1 ts) {
        assertNotNull(ts);
        assertNotNull(ts.mBankList);
//        assertTrue(ts.mBankList.size() == 4);
    }
}
