package biz.kulik.android.jaxb.library.Annotations.adapters;

import java.lang.reflect.ParameterizedType;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 9:55 AM
 */
public abstract class XmlAdapter<ValueType, BoundType>{

    protected XmlAdapter() {}
    public abstract BoundType unmarshal(ValueType v) throws Exception;
    public abstract ValueType marshal(BoundType v) throws Exception;

    public static Class<?> getUnmarsalerType(XmlAdapter adapter) {
        Class<?> clazz = (Class<?>) ((ParameterizedType) adapter.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (Object.class.equals(clazz)) {
            clazz = null;
        }
        return clazz;
    }

    public static Class<?> getMarsalerType(XmlAdapter adapter) {
        Class<?> clazz = (Class<?>) ((ParameterizedType) adapter.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        if (Object.class.equals(clazz)) {
            clazz = null;
        }
        return clazz;
    }
}
