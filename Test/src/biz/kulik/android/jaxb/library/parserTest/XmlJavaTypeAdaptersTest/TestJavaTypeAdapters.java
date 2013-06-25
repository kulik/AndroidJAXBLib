package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import biz.kulik.android.jaxb.library.parserTest.TS_Roster.GetRosterResponse;
import biz.kulik.android.jaxb.library.parserTest.TestDataTS.GetTSSavedResponse;
import biz.kulik.android.jaxb.library.parserTest.TestLongData4.RootBusStop;

import java.io.InputStream;
import java.util.Date;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters extends ParserAbstractTest<MyBean> {

    public void testParse9JSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_java_type_adapters, MyBean.class);
    }

    @Override
    protected void assertTestData(MyBean ts) {
        assertNotNull(ts);
        assertNotNull(ts.myDate);
        assertEquals(ts.myDate, new Date(597877200000l));
        //TODO make more assertations

    }
}
