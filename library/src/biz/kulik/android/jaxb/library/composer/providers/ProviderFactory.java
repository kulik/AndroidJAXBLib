package biz.kulik.android.jaxb.library.composer.providers;

import biz.kulik.android.jaxb.library.Annotations.adapters.ComposerException;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.kulik.android.jaxb.library.composer.providers.jsonProvider.JSONArrayProvider;
import biz.kulik.android.jaxb.library.composer.providers.jsonProvider.JSONObjectProvider;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.xmlPovider.XMLObjectProvider;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * User: nata, kulik
 * Date: 9/21/12
 * Time: 4:14 PM
 */
public class ProviderFactory {

    private Document mDocument;
    private boolean isRootXml = true;
    private ProviderTypes mType;

    public ProviderFactory(ProviderTypes ad) {
        mType = ad;
    }

    public void newDocument() {
        if (mType == ProviderTypes.XMLProvider) {
            try {
                DocumentBuilderFactory documentBuilderFactory =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = null;
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
                mDocument = documentBuilder.newDocument();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T createProvider(Class<T> objClass, String root) {
        T provider = null;
        switch (mType) {
            case XMLProvider:
                try {
                provider = (T) new XMLObjectProvider(mDocument, root);
                } catch (DOMException e) {
                    throw new ComposerException("Exception like @XMLRootElement doesn't exist, or some name of element or arrtibute is free string: " + e.getMessage());
                }
                if (isRootXml) {
                    mDocument.appendChild((Node) ((XMLObjectProvider)provider).getWrappedObject());
                    isRootXml = false;
                }

                break;
            case JSONProvider:
                if (UMOArray.class.equals(objClass)) {
                    provider = (T) new JSONArrayProvider();
                } else if (UMOObject.class.equals(objClass)) {
                    provider = (T) new JSONObjectProvider();
                } else {
                    throw new IllegalArgumentException("This type of provider is not implemented yet.");
                }
                break;
        }
        return provider;
    }
}
