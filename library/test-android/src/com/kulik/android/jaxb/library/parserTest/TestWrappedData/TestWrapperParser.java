package com.kulik.android.jaxb.library.parserTest.TestWrappedData;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestWrapperParser extends ParserAbstractTest<Menu> {

    public void testJSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_wrappers_json, Menu.class);
    }

    public void testWrapperParseXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_wrappers_xml, Menu.class);
    }

    @Override
    protected void assertTestData(Menu menu) {
        assertNotNull(menu);
        assertNotNull(menu.categories);
        assertTrue(menu.categories.size() == 3);
        //0
        assertNotNull(menu.categories.get(0));
        assertNotNull(menu.categories.get(0).mEl);
        assertEquals(menu.categories.get(0).mEl, "element0");

        assertNotNull(menu.categories.get(0).mId);
        assertEquals(menu.categories.get(0).mId, "toolCategory");

        assertNotNull(menu.categories.get(0).mOrdering);
        assertEquals(menu.categories.get(0).mOrdering.intValue(), 0);
        //1
        assertNotNull(menu.categories.get(1));
        assertNotNull(menu.categories.get(1).mEl);
        assertEquals(menu.categories.get(1).mEl, "element20");

        assertNotNull(menu.categories.get(1).mId);
        assertEquals(menu.categories.get(1).mId, "toolCategory1");

        assertNotNull(menu.categories.get(1).mOrdering);
        assertEquals(menu.categories.get(1).mOrdering.intValue(), 10);
        //2
        assertNotNull(menu.categories.get(2));
        assertNotNull(menu.categories.get(2).mEl);
        assertEquals(menu.categories.get(2).mEl, "element10");

        assertNotNull(menu.categories.get(2).mId);
        assertEquals(menu.categories.get(2).mId, "toolCategory2");

        assertNotNull(menu.categories.get(2).mOrdering);
        assertEquals(menu.categories.get(2).mOrdering.intValue(), 20);

        assertNotNull(menu.mMyString);
        assertEquals(menu.mMyString, "MyString");

        assertNotNull(menu.category);
        assertNotNull(menu.category.mEl);
        assertEquals(menu.category.mEl, "element");

        assertNotNull(menu.category.mId);
        assertEquals(menu.category.mId, "toolCostom");

        assertNotNull(menu.category.mOrdering);
        assertEquals(menu.category.mOrdering.intValue(), 40);
    }
}

