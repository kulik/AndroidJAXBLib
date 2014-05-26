/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
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

    public void testParse9JSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_primitive_json, PrimitivesTypes.class);
    }

    public void testParse9XML() throws Exception {
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
