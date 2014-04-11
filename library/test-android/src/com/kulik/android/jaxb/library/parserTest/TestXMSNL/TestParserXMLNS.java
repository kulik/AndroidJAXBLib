package com.kulik.android.jaxb.library.parserTest.TestXMSNL;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParserXMLNS extends ParserAbstractTest<GetFolderResponse> {
//
//    public void testParseXMLNS() throws Exception {
//        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_9_json, GetFolderResponse.class);
//    }

    public void testParseXMLNS() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.xmlns_test, GetFolderResponse.class);
    }

    @Override
    protected void assertTestData(GetFolderResponse gf) {
        assertNotNull(gf);
        assertNotNull(gf.getFolderList());
        assertTrue(gf.getFolderList().size() == 1);
        assertNotNull(gf.getFolderList().get(0));
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
