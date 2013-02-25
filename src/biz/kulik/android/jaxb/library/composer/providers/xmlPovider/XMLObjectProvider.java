package biz.kulik.android.jaxb.library.composer.providers.xmlPovider;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import org.w3c.dom.Element;

/**
 * User: kulik
 * Date: 2/19/13
 * Time: 5:06 PM
 */
public class XMLObjectProvider implements UMOObject {

    private Element mElement;

    @Override
    public Object getWrappedObject() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void put(String key, UMO umo) {

    }

    @Override
    public void putAnnotationStr(String annotationName, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAnnotationInt(String annotationName, Integer value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAnnotationLong(String annotationName, Long value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAnnotationFloat(String annotationName, Float value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAnnotationDouble(String annotationName, Double value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAnnotationBoolean(String annotationName, Boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueStr(String valueName, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueInt(String valueName, Integer value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueLong(String valueName, Long value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueFloat(String valueName, Float value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueDouble(String valueName, Double value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putValueBoolean(String valueName, Boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
