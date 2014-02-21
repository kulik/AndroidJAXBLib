package com.kulik.android.jaxb.library.composer.providers.abstractProvider;

/**
 * User: kulik
 * Date: 10/11/12
 * Time: 9:42 PM
 */
public interface UMOObject extends UMO {
    //TODO add primitive appenders
    //TODO add checking for null
    public void put(String key, UMO umo);

    public void putArray(String valueName, UMO value);

    public void putAttributeStr(String annotationName, String value);

    public void putAttributeInt(String annotationName, Integer value);

    public void putAttributeLong(String annotationName, Long value);

    public void putAttributeFloat(String annotationName, Float value);

    public void putAttributeDouble(String annotationName, Double value);

    public void putAttributeBoolean(String annotationName, Boolean value);


    public void putValueStr(String valueName, String value);

    public void putValueInt(String valueName, Integer value);

    public void putValueLong(String valueName, Long value);

    public void putValueFloat(String valueName, Float value);

    public void putValueDouble(String valueName, Double value);

    public void putValueBoolean(String valueName, Boolean value);

}
