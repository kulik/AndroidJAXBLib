package biz.kulik.android.jaxb.library.composer.providers.xmlPovider;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * User: kulik
 * Date: 2/19/13
 * Time: 5:06 PM
 */
public class XMLObjectProvider implements UMOObject, UMOArray {

    Document mDocument;

    private Element mElement;

    public XMLObjectProvider(Document document, String rootElement) throws DOMException {
        mDocument = document;
        mElement = document.createElement(rootElement);
    }

    @Override
    public Object getWrappedObject() {
        return mElement;
    }

    @Override
    public void setWrappedObject(Object obj) {
        mElement = (Element) obj;
    }

    @Override
    public Object getRootDocument() {
        return mDocument;
    }

    @Override
    public void put(String key, UMO umo) {

        mElement.appendChild((Element) umo.getWrappedObject());
    }

    @Override
    public void putAttributeStr(String annotationName, String value) {
        mElement.setAttribute(annotationName, value);
    }

    @Override
    public void putAttributeInt(String annotationName, Integer value) {
        putAttributeStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAttributeLong(String annotationName, Long value) {
        putAttributeStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAttributeFloat(String annotationName, Float value) {
        putAttributeStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAttributeDouble(String annotationName, Double value) {
        putAttributeStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAttributeBoolean(String annotationName, Boolean value) {
        putAttributeStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putValueStr(String valueName, String value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(value));
        mElement.appendChild(elem);
    }

    @Override
    public void putValueInt(String valueName, Integer value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

    @Override
    public void putValueLong(String valueName, Long value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

    @Override
    public void putValueFloat(String valueName, Float value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

    @Override
    public void putValueDouble(String valueName, Double value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

    @Override
    public void putValueBoolean(String valueName, Boolean value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

//    @Override
//    public void put(UMO value) {
//        mElement.appendChild((Element) value.getWrappedObject());
//    }

    @Override
    public void putArray(String key, UMO value) {
//        Node parent = mElement.getParentNode();
//        parent.removeChild(mElement);
//        mElement.appendChild((Element) value.getWrappedObject());
        value.setWrappedObject(mElement);
//        mElement = (Element) parent;
//        parent.replaceChild(mElement, (Node) value.getWrappedObject());
    }
}
