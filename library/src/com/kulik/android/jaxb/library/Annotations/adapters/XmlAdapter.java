/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
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
