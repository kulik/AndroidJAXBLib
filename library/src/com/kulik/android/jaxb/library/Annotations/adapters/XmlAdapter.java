package com.kulik.android.jaxb.library.Annotations.adapters;

import com.kulik.android.jaxb.library.adapters.AdapterException;

import java.lang.reflect.ParameterizedType;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 9:55 AM
 */
public abstract class XmlAdapter<ValueType, BoundType> {

    private static final boolean ADAPTER_DEBUG = true;

    protected XmlAdapter() {
    }

    public abstract BoundType unmarshal(ValueType v) throws Exception;

    public abstract ValueType marshal(BoundType v) throws Exception;

    public static Class<?> getUnMarshalerType(XmlAdapter adapter) {
        Class<?> clazz = (Class<?>) ((ParameterizedType) adapter.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    public static Class<?> getMarshalerType(XmlAdapter adapter) {
        Class<?> clazz = (Class<?>) ((ParameterizedType) adapter.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

    public static <V, T> V unmarshal(XmlAdapter<T, V> adapter, T value) throws AdapterException {
        try {
            return adapter.unmarshal(value);
        } catch (Exception e) {
            throw new AdapterException(e);
        }
    }

    public static <T, V> T marshal(XmlAdapter<T, V> adapter, V value) throws AdapterException {
        try {
            return adapter.marshal(value);
        } catch (Exception e) {
            throw new AdapterException(e);
        }
    }

//    public static void checkAdapterCompatibility(XmlAdapter adapter, Class<?> clazz) {
//        if (ADAPTER_DEBUG) {
//            if (!clazz.isAssignableFrom(XmlAdapter.getMarshalerType(adapter))) {
//                throw new XmlAdapterTypesException();
//            }
//        }
//    }
}
