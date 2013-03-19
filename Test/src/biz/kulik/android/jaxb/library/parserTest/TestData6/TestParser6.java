package biz.kulik.android.jaxb.library.parserTest.TestData6;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

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

       InputStream inputStream = getContext().getResources().openRawResource(R.raw.test_6_xml);

        ParserImpl parser = new ParserImpl(UnMarshalerTypes.XMLAdapter);

        TSCreateRsp ts;
        ts = parser.parse(TSCreateRsp.class, inputStream);
        assertTestDate6(ts);

    }

    private void assertTestDate6( TSCreateRsp ts) {

        assertNotNull(ts);
        assertNotNull(ts.text);
        assertEquals(ts.text, "TimeSheet VMT0000602 has been Saved.");
    }

}
