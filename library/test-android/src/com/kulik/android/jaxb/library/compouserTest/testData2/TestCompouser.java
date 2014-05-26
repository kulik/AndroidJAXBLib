/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.compouserTest.testData2;

import android.test.AndroidTestCase;
import android.util.Log;

import com.kulik.android.jaxb.library.adapters.AdapterException;
import com.kulik.android.jaxb.library.composer.Composer;
import com.kulik.android.jaxb.library.composer.ComposerImpl;
import com.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import com.kulik.android.jaxb.library.compouserTest.testData1.RootProxy;

//import com.kulik.android.jaxb.library.DocUtils;

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

        try {
            UMO umo = (UMO) composer.compose(rootObject);
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }

//        Log.v(TAG, DocUtils.getStringFromDoc((Document) umo.getRootDocument()));
        assertTrue(true);
    }
}
