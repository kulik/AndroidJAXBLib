package biz.mobidev.android.jaxb.library;

import android.test.AndroidTestCase;
import biz.mobidev.android.jaxb.library.parser.AdapterTypes;
import biz.mobidev.android.jaxb.library.parser.ParserImpl;

import java.io.ByteArrayInputStream;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestXMLParser extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParse() {
        String xml = new String("<SearchSuggestion xmlns=\"http://opensearch.org/searchsuggest2\" version=\"2.0\">" +
                "<Query xml:space=\"preserve\">sun</Query>" +
                "<Section>" +
                "<Item>" +
                "<Image source=\"http://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Sun_-_August_1%2C_2010.jpg/50px-Sun_-_August_1%2C_2010.jpg\" width=\"50\" height=\"45\"/>" +
                "<Text xml:space=\"preserve\">Sun</Text>" +
                "<Description xml:space=\"preserve\">" +
                "The Sun is the star at the center of the Solar System. It is almost perfectly spherical and consists of hot plasma interwoven with magnetic fields." +
                "</Description>" +
                "<Url xml:space=\"preserve\">http://en.wikipedia.org/wiki/Sun</Url>" +
                "</Item>" +

                "</Section>" +
                "</SearchSuggestion>");
        ParserImpl<SearchSuggestion> parser = new ParserImpl<SearchSuggestion>(AdapterTypes.XMLAdapter);

        SearchSuggestion se;
        se = parser.parse(SearchSuggestion.class, new ByteArrayInputStream(xml.getBytes()));

        assertTrue(true);
        String s = "Sun";
        //String ss = se.getQuery().getItem().get(0).

    }
}
