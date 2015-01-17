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
package com.kulik.android.jaxb.library.composer;

import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;

/**
 * User: kulik
 * Date: 7/1/13
 * Time: 8:43 PM
 */
public class SimpleValueUtils {

    public static boolean processAtributeValue(Object value, Class<?> valueType, String annotationName, UMOObject sobj) {

        if (String.class.equals(valueType)) {
            sobj.putAttributeStr(annotationName, (String) value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.putAttributeInt(annotationName, (Integer) value);
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.putAttributeLong(annotationName, (Long) value);
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.putAttributeFloat(annotationName, (Float) value);
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.putAttributeDouble(annotationName, (Double) value);
            return true;
        } else if (Boolean.class.equals(valueType)) {
            sobj.putAttributeBoolean(annotationName, (Boolean) value);
            return true;
        }
        return false;
    }

    public static boolean processSimpleValue(Object value, Class<?> valueType, String valueName, UMOObject sobj) {

        if (String.class.equals(valueType)) {
            sobj.putValueStr(valueName, (String) value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.putValueInt(valueName, (Integer) value);
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.putValueLong(valueName, (Long) value);
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.putValueFloat(valueName, (Float) value);
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.putValueDouble(valueName, (Double) value);
            return true;
        } else if (Boolean.class.equals(valueType)) {
            sobj.putValueBoolean(valueName, (Boolean) value);
            return true;
        }
        return false;
    }

    public static boolean processSimpleValue(Object value, Class<?> valueType, UMOObject sobj) {

        if (String.class.equals(valueType)) {
            sobj.putValueStr((String) value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.putValueInt((Integer) value);
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.putValueLong((Long) value);
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.putValueFloat((Float) value);
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.putValueDouble((Double) value);
            return true;
        } else if (Boolean.class.equals(valueType)) {
            sobj.putValueBoolean((Boolean) value);
            return true;
        }
        return false;
    }

    public static boolean processPrimitiveValue(Object obj, Class<?> valueType, String valueName, UMOObject sobj) throws IllegalAccessException {

        if (Integer.TYPE.equals(valueType)) {
            sobj.putValueInt(valueName, Integer.valueOf((Integer) obj));
            return true;
        } else if (Long.TYPE.equals(valueType)) {
            sobj.putValueLong(valueName, Long.valueOf((Long) obj));
            return true;
        } else if (Float.TYPE.equals(valueType)) {
            sobj.putValueFloat(valueName, Float.valueOf((Float) obj));
            return true;
        } else if (Double.TYPE.equals(valueType)) {
            sobj.putValueDouble(valueName, Double.valueOf((Double) obj));
            return true;
        } else if (Boolean.TYPE.equals(valueType)) {
            sobj.putValueBoolean(valueName, Boolean.valueOf((Boolean) obj));
            return true;
        }
        return false;
    }

    public static boolean processPrimitiveValue(Object obj, Class<?> valueType, UMOObject sobj) throws IllegalAccessException {

        if (Integer.TYPE.equals(valueType)) {
            sobj.putValueInt(Integer.valueOf((Integer) obj));
            return true;
        } else if (Long.TYPE.equals(valueType)) {
            sobj.putValueLong(Long.valueOf((Long) obj));
            return true;
        } else if (Float.TYPE.equals(valueType)) {
            sobj.putValueFloat(Float.valueOf((Float) obj));
            return true;
        } else if (Double.TYPE.equals(valueType)) {
            sobj.putValueDouble(Double.valueOf((Double) obj));
            return true;
        } else if (Boolean.TYPE.equals(valueType)) {
            sobj.putValueBoolean(Boolean.valueOf((Boolean) obj));
            return true;
        }
        return false;
    }

    public static boolean processPrimitiveAttributes(Object obj, Class<?> valueType, String valueName, UMOObject sobj) throws IllegalAccessException {

        if (Integer.TYPE.equals(valueType)) {
            sobj.putAttributeInt(valueName, Integer.valueOf((Integer) obj));
            return true;
        } else if (Long.TYPE.equals(valueType)) {
            sobj.putAttributeLong(valueName, Long.valueOf((String) obj));
            return true;
        } else if (Float.TYPE.equals(valueType)) {
            sobj.putAttributeFloat(valueName, Float.valueOf((Float) obj));
            return true;
        } else if (Double.TYPE.equals(valueType)) {
            sobj.putAttributeDouble(valueName, Double.valueOf((Double) obj));
            return true;
        } else if (Boolean.TYPE.equals(valueType)) {
            sobj.putAttributeBoolean(valueName, Boolean.valueOf((Boolean) obj));
            return true;
        }
        return false;
    }

}
