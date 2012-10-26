package biz.mobidev.android.jaxb.library.parser;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations.XMLAttribute;
import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 11:09 AM
 */
public class ParserImpl implements Parser {
    private static final String TAG = ParserImpl.class.getSimpleName();
    private AdapterTypes mAdapterType;

    public ParserImpl(AdapterTypes ad) {
        mAdapterType = ad;
    }

    @Override
    public <T> T parse(Class<T> cls, String data) {
        ElementAdapter rootElement = ElementAdapterFactory.createAdapter(mAdapterType, data);
        T rootObj = null;
        rootObj = parse(cls,rootElement);
        return rootObj;
    }

    @Override
    public <T> T parse(Class<T> cls, InputStream data) {
        ElementAdapter rootElement = ElementAdapterFactory.createAdapter(mAdapterType, data);
        T rootObj = null;
        rootObj = parse(cls,rootElement);
        return rootObj;
    }

    private <T> T parse(Class<T> cls, ElementAdapter rootElement) {
        T rootObj = null;
        try {
            rootObj = cls.newInstance();
            processObject(rootObj, rootElement);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "InvocationTargetException while parsing: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException while parsing: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, "InstantiationException while parsing: " + e.getMessage());
        }
        return rootObj;
    }


    protected void processObject(Object obj, ElementAdapter elem) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            String xmlValue = "";

            if (field.isAnnotationPresent(XMLAttribute.class)) {
                String annotationName = field.getAnnotation(XMLAttribute.class).name();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, field, obj);
            } else if (field.isAnnotationPresent(XMLValue.class)) {

                boolean simpleTypeParsed = processSimpleValue(elem, field, obj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                }
            }
        }

    }
    /**
     *
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementAdapter elem, Field field, T obj) throws IllegalAccessException{
        String annotationName = field.getAnnotation(XMLValue.class).name();
        String value = elem.getValue(annotationName);

        field.setAccessible(true);
        Class<?> valueType = field.getType();
        if (String.class.equals(valueType)) {
            field.set(obj, value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            field.set(obj, Integer.valueOf(value));
            return true;
        } else if (Long.class.equals(valueType)) {
            field.set(obj, Long.valueOf(value));
            return true;
        } else if (Float.class.equals(valueType)) {
            field.set(obj, Float.valueOf(value));
            return true;
        } else if (Double.class.equals(valueType)) {
            field.set(obj, Double.valueOf(value));
            return true;
        } else if (Boolean.class.equals(valueType)) {
            field.set(obj, Boolean.valueOf(value));
            return true;
        }
        return false;
    }


    /**
     * @param value String value from xml document
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processAtributeValue(String value, Field field, T obj) throws IllegalAccessException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        if (String.class.equals(valueType)) {
            field.set(obj, value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            field.set(obj, Integer.valueOf(value));
            return true;
        } else if (Long.class.equals(valueType)) {
            field.set(obj, Long.valueOf(value));
            return true;
        } else if (Float.class.equals(valueType)) {
            field.set(obj, Float.valueOf(value));
            return true;
        } else if (Double.class.equals(valueType)) {
            field.set(obj, Double.valueOf(value));
            return true;
        } else if (Boolean.class.equals(valueType)) {
            field.set(obj, Boolean.valueOf(value));
            return true;
        }
        return false;
    }

    protected <T> void processComplexValue(ElementAdapter elem, Field field, T obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(XMLValue.class).name();

        if (valueType == List.class) {
            List<ElementAdapter> children = elem.getChildren(annotName);
            List objects = new ArrayList();
            field.set(obj, objects);

            Type genericType = field.getGenericType();
            for (int i = 0; i < children.size(); i++) {
                Object item = null;
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType paramType = (ParameterizedType) genericType;
                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                    item = tClass.newInstance();
                    objects.add(item);
                }
                processObject(item, children.get(i));
            }
        } else if (valueType.isArray()) {
            //TODO Need to implement
//            NodeList childNodes = elem.getChildNodes();
//            Type genericType = field.getGenericType();
//            ParameterizedType paramType = (ParameterizedType) genericType;
//            Class<?> aClass = (Class<T>) paramType.getActualTypeArguments()[0];
//
//            field.set(obj, Array.newInstance(aClass, childNodes.getLength()));
//
//            for (int i = 0; i < childNodes.getLength(); i++) {
//
//                processObject(item, (Element) childNodes.item(i));
//            }
        } else {
            ElementAdapter child = elem.getChild(annotName);
            Class<?> type = field.getType();
            Object childObj = type.newInstance();
            field.set(obj,childObj);
            processObject(childObj, child);
        }
    }


}
