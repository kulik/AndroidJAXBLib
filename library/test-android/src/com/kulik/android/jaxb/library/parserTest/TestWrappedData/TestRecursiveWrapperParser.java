package com.kulik.android.jaxb.library.parserTest.TestWrappedData;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestRecursiveWrapperParser extends ParserAbstractTest<WrappedRecursiveLists> {

    public void testRecursiveWrapperParseJSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_recursive_wrappers_json, WrappedRecursiveLists.class);
    }

    public void testRecursiveWrapperParseXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_recursive_wrappers_xml, WrappedRecursiveLists.class);
    }

    @Override
    protected void assertTestData(WrappedRecursiveLists rec) {
        assertNotNull(rec);
        assertNotNull(rec.level1List);
        assertTrue(rec.level1List.size() == 3);
        //0
        for (int i = 0; i < 3; i++) {
            assertNotNull(rec.level1List.get(i));
            assertNotNull(rec.level1List.get(i).level2List);
            assertTrue(rec.level1List.get(i).level2List.size() == 3);
            for (int j = 0; j < 3; j++) {
                // 0:0:x
                assertNotNull(rec.level1List.get(i).level2List.get(j));
                assertNotNull(rec.level1List.get(i).level2List.get(j).level3List);
                assertTrue(rec.level1List.get(i).level2List.get(j).level3List.size() == 3);
                for (int k = 0; k < 3; k++) {
                    assertNotNull(rec.level1List.get(i).level2List.get(j).level3List.get(k));
                    assertNotNull(rec.level1List.get(i).level2List.get(j).level3List.get(k).stringAttr);
                    assertEquals(rec.level1List.get(i).level2List.get(j).level3List.get(k).stringAttr, "attr->" + i + ":" + j + ":" + k);
                    assertNotNull(rec.level1List.get(i).level2List.get(j).level3List.get(k).stringElem);
                    assertEquals(rec.level1List.get(i).level2List.get(j).level3List.get(k).stringElem, "elem->" + i + ":" + j + ":" + k);

                }
            }
        }
    }
}

