package biz.mobidev.android.jaxb.library.parserTest;

import android.test.InstrumentationTestCase;
import biz.mobidev.android.jaxb.library.SearchSuggestion;
import biz.mobidev.android.jaxb.library.parser.AdapterTypes;
import biz.mobidev.android.jaxb.library.parser.ParserImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestParser extends InstrumentationTestCase {
    private static final String TAG = TestParser.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParseJSON() {
        //start test JSON
        String json = "{\"status\":\"success\"," +
                        "\"data\":[" +
                                    "{\"property\":{" +
                                            "\"adid\":37827466," +
                                            "\"mainImageUrl\":\"http://finncdn.no/mmo/2012/10/vertical-2/17/6/378/274/66_1520550395.jpg\"," +
                                            "\"priceSuggestion\":2450000," +
                                            "\"address\":\"Gullagata 27 A\"," +
                                            "\"postcode\":\"3513\"," +
                                            "\"location\":\"Hønefoss\"," +
                                            "\"sold\":false" +
                                       "}," +
                                      "\"rate\":4," +
                                      "\"own\":true," +
                                      "\"friend\":true}," +
                                    "{\"property\":{" +
                                            "\"adid\":37827294," +
                                            "\"mainImageUrl\":\"http://finncdn.no/mmo/2012/10/vertical-2/17/4/378/272/94_2108968499.jpg\"," +
                                            "\"priceSuggestion\":1200000," +
                                            "\"address\":\"Bjørneveien 14 B\"," +
                                            "\"postcode\":\"3617\"," +
                                            "\"location\":\"Kongsberg\"," +
                                            "\"sold\":false" +
                                        "}," +
                                       "\"rate\":4," +
                                       "\"own\":true," +
                                       "\"friend\":true}" +
                                "]" +
                      "}";
        ParserImpl parser = new ParserImpl(AdapterTypes.JSONAdapter);

        TestStorage se;
        se = parser.parse(TestStorage.class, json);
        assertTrue(true);
    }

//    public void testParseJSON() {
//        // To load text file
//        InputStream jsonStream = null;
//        try {
//
//            jsonStream = getInstrumentation().getContext().openFileInput("json");
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//        ParserImpl parser2 = new ParserImpl(AdapterTypes.JSONAdapter);
//
//        SearchSuggestion se2;
//        se2 = parser2.parse(SearchSuggestion.class, jsonStream);
//
//
//        assertTrue(true);
//
//    }

//    public void testJSONParser() {
//        InputStream jsonStream = null;
//        try {
//               // getContext().getResources().openRawResource();
//            //jsonStream = new BufferedInputStream(this.getContext().openFileInput("countries_json"));
//
//            //jsonStream = getContext().getAssets().open("countries_json");
//        } catch (IOException e) {
//            Log.v("Test","IOEXception");
//        }
////        File file = null;
////        InputStream in = null;
////
////        in = this.getClass().getClassLoader().getResourceAsStream("raw/countries_json");
//
//
//        ParserImpl parser = new ParserImpl(AdapterTypes.JSONAdapter);
//        Country countries;
//        countries = parser.parse(Country.class, jsonStream);
//
//    }

}
