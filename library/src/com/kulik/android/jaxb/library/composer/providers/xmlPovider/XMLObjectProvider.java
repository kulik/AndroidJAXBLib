package com.kulik.android.jaxb.library.composer.providers.xmlPovider;

import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
        putValue(valueName, value);
    }

    @Override
    public void putValueLong(String valueName, Long value) {
        putValue(valueName, value);
    }

    @Override
    public void putValueFloat(String valueName, Float value) {
        putValue(valueName, value);
    }

    @Override
    public void putValueDouble(String valueName, Double value) {
        putValue(valueName, value);
    }

    @Override
    public void putValueBoolean(String valueName, Boolean value) {
        putValue(valueName, value);
    }

    @Override
    public void putValueStr(String value) {
        putValue(value);
    }

    @Override
    public void putValueInt(Integer value) {
        putValue(value);
    }

    @Override
    public void putValueLong(Long value) {
        putValue(value);
    }

    @Override
    public void putValueFloat(Float value) {
        putValue(value);
    }

    @Override
    public void putValueDouble(Double value) {
        putValue(value);
    }

    @Override
    public void putValueBoolean(Boolean value) {
        putValue(value);
    }

    private void putValue(Object value) {
        mElement.appendChild(mDocument.createTextNode(String.valueOf(value)));
    }

    public void putValue(String valueName, Object value) {
        Element elem = mDocument.createElement(valueName);
        elem.appendChild(mDocument.createTextNode(String.valueOf(value)));
        mElement.appendChild(elem);
    }

    @Override
    public void putArray(String key, UMO value) {
        value.setWrappedObject(mElement);
    }
}
