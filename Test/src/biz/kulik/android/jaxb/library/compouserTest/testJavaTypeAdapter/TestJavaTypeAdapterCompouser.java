package biz.kulik.android.jaxb.library.compouserTest.testJavaTypeAdapter;

import android.test.AndroidTestCase;
import android.util.Log;
import biz.kulik.android.jaxb.library.DocUtils;
import biz.kulik.android.jaxb.library.adapters.AdapterException;
import biz.kulik.android.jaxb.library.composer.Composer;
import biz.kulik.android.jaxb.library.composer.ComposerImpl;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.MyBean;
import org.w3c.dom.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//import biz.kulik.android.jaxb.library.DocUtils;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestJavaTypeAdapterCompouser extends AndroidTestCase {
    private static final String TAG = TestJavaTypeAdapterCompouser.class.getSimpleName();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public void testCompouse2JSON() {
        // To load text file
        MyBean bean = new MyBean();
        try {
            bean.myDate = dateFormat.parse("12.12.1988");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Composer composer = new ComposerImpl(ProviderTypes.JSONProvider);

        UMO umo = null;
        try {
            umo = (UMO) composer.compose(bean);
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }
        Log.v(TAG, umo.getWrappedObject().toString());
        assertEquals(umo.getWrappedObject().toString(), "{\"my_date\":\"12.12.1988\"}");

    }

    public void testCompouseXML() {
        MyBean bean = new MyBean();
        try {
            bean.myDate = dateFormat.parse("12.12.1988");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Composer composer = new ComposerImpl(ProviderTypes.XMLProvider);

        try {
            UMO umo = (UMO) composer.compose(bean);

            Log.v(TAG, DocUtils.getStringFromDoc((Document) umo.getRootDocument()));
            assertEquals(DocUtils.getStringFromDoc((Document) umo.getRootDocument()), "<?xml version=\"1.0\" encoding=\"UTF-8\"?><my_bean><my_date>12.12.1988</my_date></my_bean>");
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
