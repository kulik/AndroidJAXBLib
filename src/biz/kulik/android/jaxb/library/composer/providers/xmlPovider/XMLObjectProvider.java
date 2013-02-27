package biz.kulik.android.jaxb.library.composer.providers.xmlPovider;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * User: kulik
 * Date: 2/19/13
 * Time: 5:06 PM
 */
public class XMLObjectProvider implements UMOObject {

    Document mDocument;

    private Element mElement;

    public XMLObjectProvider(Document document, String rootElement) {
        mDocument = document;
        mElement = document.createElement(rootElement);
    }

    @Override
    public Object getWrappedObject() {
        return mElement;
    }

    @Override
    public void put(String key, UMO umo) {
        mElement.appendChild((Element) umo.getWrappedObject());
    }

    @Override
    public void putAnnotationStr(String annotationName, String value) {
        mElement.setAttribute(annotationName,value);
    }

    @Override
    public void putAnnotationInt(String annotationName, Integer value) {
        putAnnotationStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAnnotationLong(String annotationName, Long value) {
        putAnnotationStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAnnotationFloat(String annotationName, Float value) {
        putAnnotationStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAnnotationDouble(String annotationName, Double value) {
        putAnnotationStr(annotationName, String.valueOf(value));
    }

    @Override
    public void putAnnotationBoolean(String annotationName, Boolean value) {
        putAnnotationStr(annotationName, String.valueOf(value));
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
}
