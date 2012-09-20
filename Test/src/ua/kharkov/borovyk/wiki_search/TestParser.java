package ua.kharkov.borovyk.wiki_search;

import android.test.AndroidTestCase;
import ua.kharkov.borovyk.wiki_search.mynetwork.AdapterTypes;
import ua.kharkov.borovyk.wiki_search.mynetwork.ParserImpl;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/18/12
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestParser extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParseXML() {
        //start test xml
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

    }

    public void testParseJSON() {
        // To load text file
        InputStream jsonStream = null;
            try {
                jsonStream = getContext().getAssets().open("JSON.txt");
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        ParserImpl<SearchSuggestion> parser2 = new ParserImpl<SearchSuggestion>(AdapterTypes.JSONAdapter);

        SearchSuggestion se2;
        se2 = parser2.parse(SearchSuggestion.class, jsonStream);




        assertTrue(true);

    }
}
