package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters extends ParserAbstractTest<MyBean> {

    public void testParseJavaTypeAdaptersJSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_java_type_adapters_json, MyBean.class);
    }

    public void testParseJavaTypeAdaptersXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_java_type_adapters_xml, MyBean.class);
    }


    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    protected void assertTestData(MyBean ts) {
        assertNotNull(ts);
        assertNotNull(ts.myDate);

        try {
            assertEquals(ts.myDate, dateFormat.parse("12.12.1988"));
        } catch (ParseException e) {
            assertTrue(e.getMessage(), false);
        }
        //TODO make more assertations

    }
}
