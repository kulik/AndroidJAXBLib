package biz.kulik.android.jaxb.library;

import android.test.AndroidTestCase;
import biz.kulik.android.jaxb.library.parser.ParserImpl;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public  abstract class ParserAbstractTest<T> extends AndroidTestCase {
    private static final String TAG = ParserAbstractTest.class.getSimpleName();

    protected void parse(UnMarshalerTypes type, int resID, Class<T> clazz) {
        InputStream inputStream = getContext().getResources().openRawResource(resID);

        ParserImpl parser = new ParserImpl(type);
        T ts = null;
        try {
            ts = parser.parse(clazz, inputStream);
        } catch (Exception e) {
            assertTrue("Parsing exception: " + e.getMessage(), false);
        }

        assertTestData(ts);
    }

    protected abstract void assertTestData(T ts);

}
