package biz.kulik.android.jaxb.library.composer.providers;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.kulik.android.jaxb.library.composer.providers.jsonProvider.JSONArrayProvider;
import biz.kulik.android.jaxb.library.composer.providers.jsonProvider.JSONObjectProvider;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.xmlPovider.XMLObjectProvider;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 4:14 PM
 */
public class ProviderFactory {

    Document mDocument;
    private ProviderTypes mType;

    public ProviderFactory(ProviderTypes ad) {
        mType = ad;
        if (mType == ProviderTypes.XMLProvider) {
            try {
                DocumentBuilderFactory documentBuilderFactory =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = null;
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
                mDocument = documentBuilder.newDocument();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public <T> T createProvider(Class<T> objClass) {
        T provider = null;
        switch (mType) {
            case XMLProvider:
                provider = (T) new XMLObjectProvider(mDocument, "root");

                break;
            case JSONProvider:
                if (UMOArray.class.equals(objClass)) {
                    provider = (T) new JSONArrayProvider();
                } else if (UMOObject.class.equals(objClass)) {
                    provider = (T) new JSONObjectProvider();
                } else {
                    throw new IllegalArgumentException("This type of provider is not inplemented yet.");
                }
                break;
        }
        return provider;
    }
}
