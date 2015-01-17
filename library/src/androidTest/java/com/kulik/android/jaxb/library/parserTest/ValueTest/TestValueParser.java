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
package com.kulik.android.jaxb.library.parserTest.ValueTest;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import com.kulik.android.jaxb.library.test.R;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestValueParser extends ParserAbstractTest<TemplateMigrate> {
    private static final String TAG = TestValueParser.class.getSimpleName();

    public void testParseXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.test_parse_value, TemplateMigrate.class);
    }

//    public void testParse4XML() {
//        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_1_xml.xml);
//
//        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);
//
//        BusStops se;
//        se = parser.parse(BusStops.class, inputStream);
//
//        assertTestDate4(lbs);
//    }

    @Override
    protected void assertTestData(TemplateMigrate ts) {
        assertNotNull(ts.noteList.get(0));
        assertEquals(ts.noteList.get(0).fileName, "template_cream_ideas.html");
        assertEquals(ts.noteList.get(0).displayName, "Ideas");
        assertNotNull(ts.noteList.get(0).attachmentList);
        assertTrue(ts.noteList.get(0).attachmentList.size() == 1);
        assertNotNull(ts.noteList.get(0).attachmentList.get(0));
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).contentId);
        assertEquals(ts.noteList.get(0).attachmentList.get(0).contentId, "c");
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).description, "d");
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).file, "template_img_4.png");
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).location, "l");
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).name, "n");
        assertNotNull(ts.noteList.get(0).attachmentList.get(0).type, "t");

        assertNotNull(ts.noteList.get(1));
        assertEquals(ts.noteList.get(1).fileName, "template_cream_action_items.html");
        assertEquals(ts.noteList.get(1).displayName, "Action Items");
        assertTrue(ts.noteList.get(1).attachmentList.size() == 3);
        assertNotNull(ts.noteList.get(1).attachmentList.get(0));
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).contentId);
        assertEquals(ts.noteList.get(1).attachmentList.get(0).contentId, "c10");
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).description, "d10");
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).file, "template_img_410.png");
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).location, "l10");
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).name, "n10");
        assertNotNull(ts.noteList.get(1).attachmentList.get(0).type, "t10");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1));
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).contentId);
        assertEquals(ts.noteList.get(1).attachmentList.get(1).contentId, "c11");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).description, "d11");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).file, "template_img_411.png");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).location, "l11");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).name, "n11");
        assertNotNull(ts.noteList.get(1).attachmentList.get(1).type, "t11");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2));
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).contentId);
        assertEquals(ts.noteList.get(1).attachmentList.get(2).contentId, "c12");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).description, "d12");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).file, "template_img_412.png");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).location, "l12");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).name, "n12");
        assertNotNull(ts.noteList.get(1).attachmentList.get(2).type, "t12");


        assertNotNull(ts.noteList.get(2));
        assertEquals(ts.noteList.get(2).fileName, "template_cream_meeting.html");
        assertEquals(ts.noteList.get(2).displayName, "Meeting");

        assertNotNull(ts.noteList.get(3));
        assertEquals(ts.noteList.get(3).fileName, "template_cream_report.html");
        assertEquals(ts.noteList.get(3).displayName, "Report with two line name");
    }
}
