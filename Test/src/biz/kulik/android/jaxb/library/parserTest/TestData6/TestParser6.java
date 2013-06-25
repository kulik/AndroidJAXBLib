package biz.kulik.android.jaxb.library.parserTest.TestData6;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser6 extends AndroidTestCase {
    private static final String TAG = TestParser6.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testParse6JSON() {

    //    InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_3_json);

      //  ParserImpl parser = new ParserImpl(UnMarshalerTypes.JSONAdapter);

//        ResponseContainer<List<ApartmentViewingsListResponse> ts;
//        ts = parser.parse(ResponseContainer<List<ApartmentViewingsListResponse>>.class, inputStream);
//        assertTestDate2(ts);
    }

    public void testParse6XML() {

//       InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_6_xml);
        String responseString ="<?xml version='1.0'?>\n" +
                "<TSCreateRsp xmlns=\"http://release-dev.provade.com//Enterprise/Tools/schemas/PRV_WORKER_API.TSCreateRsp.v1\">\n" +
                "    <text>TimeSheet VMT0000602 has been Saved.</text>\n" +
                "</TSCreateRsp>";
        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);
        AbstractResponse result = (AbstractResponse) parser.parse(ParseCreateTSWeekResponse.class, responseString);

//        PrimitivesTypes ts;
//        ts = parser.parse(PrimitivesTypes.class, inputStream);

        assertTestDate6((ParseCreateTSWeekResponse) result);

    }



    private void assertTestDate6( ParseCreateTSWeekResponse ts) {

        assertNotNull(ts);
        assertNotNull(ts.text);
        assertEquals(ts.text, "TimeSheet VMT0000602 has been Saved.");
    }

}
