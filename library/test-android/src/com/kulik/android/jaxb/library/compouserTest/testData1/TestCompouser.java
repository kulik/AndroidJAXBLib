package com.kulik.android.jaxb.library.compouserTest.testData1;

import android.test.AndroidTestCase;
import android.util.Log;

import com.kulik.android.jaxb.library.DocUtils;
import com.kulik.android.jaxb.library.adapters.AdapterException;
import com.kulik.android.jaxb.library.composer.Composer;
import com.kulik.android.jaxb.library.composer.ComposerImpl;
import com.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;

import org.w3c.dom.Document;

//import com.kulik.android.jaxb.library.DocUtils;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestCompouser extends AndroidTestCase {
    private static final String TAG = TestCompouser.class.getSimpleName();

    public void testCompouseJSON() {
        // To load text file
        RootProxy rootObject = new RootProxy();
        Composer composer = new ComposerImpl(ProviderTypes.JSONProvider);

        UMO umo = null;
        try {
            umo = (UMO) composer.compose(rootObject);
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }
        Log.v(TAG, umo.getWrappedObject().toString());
        assertTrue(true);
    }

    public void testCompouseXML() {
        RootProxy rootObject = new RootProxy();
        Composer composer = new ComposerImpl(ProviderTypes.XMLProvider);

        UMO umo = null;
        try {
            umo = (UMO) composer.compose(rootObject);
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }

        Log.v(TAG, DocUtils.getStringFromDoc((Document) umo.getRootDocument()));
        assertTrue(true);
    }
}
