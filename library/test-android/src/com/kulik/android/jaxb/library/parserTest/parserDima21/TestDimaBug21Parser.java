package com.kulik.android.jaxb.library.parserTest.parserDima21;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestDimaBug21Parser extends ParserAbstractTest<Response> {

    public void testJSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.bug_21_json, Response.class);
    }

    @Override
    protected void assertTestData(Response response) {
        assertNotNull(response);
//        assertNotNull(menu.categories);
//        assertTrue(menu.categories.size() == 3);
        //TODO add asserts
    }
}