package biz.kulik.android.jaxb.library.compouserTest.testData2;

import android.test.AndroidTestCase;
import android.util.Log;
import biz.kulik.android.jaxb.library.composer.Composer;
import biz.kulik.android.jaxb.library.composer.ComposerImpl;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.compouserTest.testData1.RootProxy;

//import biz.kulik.android.jaxb.library.DocUtils;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestCompouser extends AndroidTestCase {
    private static final String TAG = TestCompouser.class.getSimpleName();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCompouse2JSON() {
        // To load text file
        RootProxy rootObject = new RootProxy();
        Composer composer = new ComposerImpl(ProviderTypes.JSONProvider);

        UMO umo = (UMO) composer.compose(rootObject);
        Log.v(TAG, umo.getWrappedObject().toString());
        assertTrue(true);

    }

    public void testCompouseXML() {
        RootProxy rootObject = new RootProxy();
        Composer composer = new ComposerImpl(ProviderTypes.XMLProvider);

        UMO umo = (UMO) composer.compose(rootObject);

//        Log.v(TAG, DocUtils.getStringFromDoc((Document) umo.getRootDocument()));
        assertTrue(true);
    }
}
