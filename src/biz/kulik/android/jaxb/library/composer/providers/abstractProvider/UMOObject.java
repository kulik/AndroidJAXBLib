package biz.kulik.android.jaxb.library.composer.providers.abstractProvider;

/**
 * User: kulik
 * Date: 10/11/12
 * Time: 9:42 PM
 */
public interface UMOObject extends UMO {

    public void put(String key, UMO umo);

    public void putAnnotationStr(String annotationName, String value);

    public void putAnnotationInt(String annotationName, Integer value);

    public void putAnnotationLong(String annotationName, Long value);

    public void putAnnotationFloat(String annotationName, Float value);

    public void putAnnotationDouble(String annotationName, Double value);

    public void putAnnotationBoolean(String annotationName, Boolean value);


    public void putValueStr(String valueName, String value);

    public void putValueInt(String valueName, Integer value);

    public void putValueLong(String valueName, Long value);

    public void putValueFloat(String valueName, Float value);

    public void putValueDouble(String valueName, Double value);

    public void putValueBoolean(String valueName, Boolean value);
}
