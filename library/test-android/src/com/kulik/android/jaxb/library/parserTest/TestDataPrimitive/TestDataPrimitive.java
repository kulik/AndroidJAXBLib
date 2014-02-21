package com.kulik.android.jaxb.library.parserTest.TestDataPrimitive;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestDataPrimitive extends ParserAbstractTest<PrimitivesTypes> {

    public void testParse9JSON() {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_primitive_json, PrimitivesTypes.class);
    }

    public void testParse9XML() {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_primitive_xml, PrimitivesTypes.class);
    }

    @Override
    protected void assertTestData(PrimitivesTypes pt) {
        assertNotNull(pt);
        assertTrue(pt.primBool);
        assertEquals(pt.primByte, 10);
        assertEquals(pt.primFloat, 0.1f);
        assertEquals(pt.primInt, 100);
        assertEquals(pt.primLong, 1000);
        assertEquals(pt.primShort, 11);
        assertEquals(pt.primDouble, 1.1);
    }
}
