package biz.kulik.android.jaxb.library.parserTest.TestLongData4;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.AdapterTypes;
import biz.kulik.android.jaxb.library.parser.ParserImpl;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestParser1 extends AndroidTestCase {
    private static final String TAG = TestParser1.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testParse1JSON() {
        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_1_json);

        ParserImpl parser = new ParserImpl(AdapterTypes.JSONAdapter);

        SearchSuggestion se;
        se = parser.parse(SearchSuggestion.class, inputStream);

        assertTestDate1(se);
    }

    public void testParse1XML() {
        InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_1_xml);

        ParserImpl parser = new ParserImpl(AdapterTypes.XMLAdapter);

        SearchSuggestion se;
        se = parser.parse(SearchSuggestion.class, inputStream);

        assertTestDate1(se);
    }

    private void assertTestDate1(SearchSuggestion se) {
        assertNotNull("", se);
        assertNotNull("", se.getSection());
        assertNotNull("", se.getSection().getItem());
        assertTrue("", se.getSection().getItem().size() == 3);
        assertNotNull("", se.getSection().getItem().get(0).getImage());
        assertNotNull("", se.getSection().getItem().get(0).getImage().getSource());
        assertNotNull("", se.getSection().getItem().get(0).getTitle());
        assertNotNull("", se.getSection().getItem().get(0).getUrl());

        assertNotNull("", se.getSection().getItem().get(1).getImage());
        assertNotNull("", se.getSection().getItem().get(1).getImage().getSource());
        assertNotNull("", se.getSection().getItem().get(1).getTitle());
        assertNotNull("", se.getSection().getItem().get(1).getUrl());

        assertNotNull("", se.getSection().getItem().get(2).getImage());
        assertNotNull("", se.getSection().getItem().get(2).getImage().getSource());
        assertNotNull("", se.getSection().getItem().get(2).getTitle());
        assertNotNull("", se.getSection().getItem().get(2).getUrl());


        assertEquals("", se.getSection().getItem().get(0).getUrl(), "http://en.wikipedia.org/wiki/Sun");
        assertEquals("", se.getSection().getItem().get(0).getTitle(), "Sun1");
        assertEquals("", se.getSection().getItem().get(0).getImage().getSource(), "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg");

        assertEquals("", se.getSection().getItem().get(1).getUrl(), "http://en.wikipedia.org/wiki/Sun1111");
        assertEquals("", se.getSection().getItem().get(1).getTitle(), "Sun2");
        assertEquals("", se.getSection().getItem().get(1).getImage().getSource(), "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_1%2C_2010.jpg");

        assertEquals("", se.getSection().getItem().get(2).getUrl(), "http://en.wikipedia.org/wiki/Sun2222");
        assertEquals("", se.getSection().getItem().get(2).getTitle(), "Sun3");
        assertEquals("", se.getSection().getItem().get(2).getImage().getSource(), "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/August_1%2C_2010.jpg");
    }

}
