package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.util.Date;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters extends ParserAbstractTest<MyBean> {

    public void testParseJavaTypeAdaptersJSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_java_type_adapters_json, MyBean.class);
    }

    public void testParseJavaTypeAdaptersXML() {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_java_type_adapters_xml, MyBean.class);
    }


    @Override
    protected void assertTestData(MyBean ts) {
        assertNotNull(ts);
        assertNotNull(ts.myDate);
        assertEquals(ts.myDate, new Date(597877200000l));
        //TODO make more assertations

    }
}
