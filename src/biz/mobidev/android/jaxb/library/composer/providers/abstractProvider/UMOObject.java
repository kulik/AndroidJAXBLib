package biz.mobidev.android.jaxb.library.composer.providers.abstractProvider;

/**
 * User: kulik
 * Date: 10/11/12
 * Time: 9:42 PM
 */
public abstract class UMOObject extends UMO {

    public abstract void put(String key, UMO umo);

    public abstract void putAnnotationStr(String annotationName, String value);

    public abstract void putAnnotationInt(String annotationName, Integer value);

    public abstract void putAnnotationLong(String annotationName, Long value);

    public abstract void putAnnotationFloat(String annotationName, Float value);

    public abstract void putAnnotationDouble(String annotationName, Double value);


    public abstract void putValueStr(String valueName, String value);

    public abstract void putValueInt(String valueName, Integer value);

    public abstract void putValueLong(String valueName, Long value);

    public abstract void putValueFloat(String valueName, Float value);

    public abstract void putValueDouble(String valueName, Double value);
}
