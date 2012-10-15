package biz.mobidev.android.jaxb.library.composer.providers.abstractProvider;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/11/12
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class UMOObject extends UMO {

    public abstract void put(String key, UMO umo);


    public abstract void putAnnotation(String annotationName, String value);

    public abstract void putAnnotation(String annotationName, Integer value);

    public abstract void putAnnotation(String annotationName, Long value);

    public abstract void putAnnotation(String annotationName, Float value);

    public abstract void putAnnotation(String annotationName, Double value);


    public abstract void putValue(String valueName, String value);

    public abstract void putValue(String valueName, Integer value);

    public abstract void putValue(String valueName, Long value);

    public abstract void putValue(String valueName, Float value);

    public abstract void putValue(String valueName, Double value);
}
