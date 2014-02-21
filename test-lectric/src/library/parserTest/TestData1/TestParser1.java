package library.parserTest.TestData1;

import com.kulik.android.jaxb.library.parser.ParserImpl;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
@RunWith(RobolectricTestRunner.class)
public class TestParser1 {

    private static final String TAG = TestParser1.class.getSimpleName();
    public static final String RES_NAME = "test_1_";

    InputStream jsonInputStream = getClass().getResourceAsStream(RES_NAME + "json.json");
    InputStream xmlInputStream = getClass().getResourceAsStream(RES_NAME + "xml.xml");

    @Test
    public void testParse1JSON() {


        ParserImpl parser = new ParserImpl(UnMarshalerTypes.JSONAdapter);

        SearchSuggestion se;
        se = parser.parse(SearchSuggestion.class, jsonInputStream);

        assertTestDate1(se);
    }

    @Test
    public void testParse1XML() {


        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);

        SearchSuggestion se;
        se = parser.parse(SearchSuggestion.class, xmlInputStream);

        assertTestDate1(se);
    }

    private void assertTestDate1(SearchSuggestion se) {
        assertNotNull("", se);
        assertNotNull("", se.section);
        assertNotNull("", se.section.item);
        assertTrue("",    se.section.item.size() == 3);
        assertNotNull("", se.section.item.get(0).image);
        assertNotNull("", se.section.item.get(0).image.source);
        assertNotNull("", se.section.item.get(0).title);
        assertNotNull("", se.section.item.get(0).url);

        assertNotNull("", se.section.item.get(1).image);
        assertNotNull("", se.section.item.get(1).image.source);
        assertNotNull("", se.section.item.get(1).title);
        assertNotNull("", se.section.item.get(1).url);

        assertNotNull("", se.section.item.get(2).image);
        assertNotNull("", se.section.item.get(2).image.source);
        assertNotNull("", se.section.item.get(2).title);
        assertNotNull("", se.section.item.get(2).url);

        assertEquals("", se.section.item.get(0).url, "http://en.wikipedia.org/wiki/Sun");
        assertEquals("", se.section.item.get(0).title, "Sun1");
        assertEquals("", se.section.item.get(0).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg");

        assertEquals("", se.section.item.get(1).url, "http://en.wikipedia.org/wiki/Sun1111");
        assertEquals("", se.section.item.get(1).title, "Sun2");
        assertEquals("", se.section.item.get(1).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_1%2C_2010.jpg");

        assertEquals("", se.section.item.get(2).url, "http://en.wikipedia.org/wiki/Sun2222");
        assertEquals("", se.section.item.get(2).title, "Sun3");
        assertEquals("", se.section.item.get(2).image.source, "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/August_1%2C_2010.jpg");
    }

}
