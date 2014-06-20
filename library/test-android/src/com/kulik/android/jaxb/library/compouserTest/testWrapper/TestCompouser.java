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
package com.kulik.android.jaxb.library.compouserTest.testWrapper;

import android.test.AndroidTestCase;

import com.kulik.android.jaxb.library.adapters.AdapterException;
import com.kulik.android.jaxb.library.composer.Composer;
import com.kulik.android.jaxb.library.composer.ComposerImpl;
import com.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import biz.kulik.android.jaxb.library.DocUtils;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestCompouser extends AndroidTestCase {
    private static final String TAG = TestCompouser.class.getSimpleName();

    public void testCompouseXML() throws AdapterException, TransformerException, UnsupportedEncodingException {
        String etalon = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\"><soap:Body><GetFolder xmlns=\"http://schemas.microsoft.com/exchange/services/2006/messages\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\"><FolderIds><t:DistinguishedFolderId Id=\"Notes\"/></FolderIds><FolderShape><t:BaseShape>Default</t:BaseShape></FolderShape></GetFolder></soap:Body></soap:Envelope>";

        RequestPreparatory preparator = new RequestPreparatory();
        Composer composer = new ComposerImpl(ProviderTypes.XMLProvider);

        EWSRequest request = new GetFolder("Notes");
        SoapRoot soapRoot = preparator.prepare(request);

        UMO umo = (UMO) composer.compose(soapRoot);
        Document doc = (Document) umo.getRootDocument();
        DOMSource domSource = new DOMSource(doc);
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        assertEquals("Compoused xml isnt matched to etalon", writer.toString("UTF-8"), etalon);
    }
}
