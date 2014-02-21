package com.kulik.android.jaxb.library.parser;

import android.util.Log;
import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.parser.providers.ElementUnmarshaler;
import com.kulik.android.jaxb.library.parser.providers.ElementUnmarshalerFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 11:09 AM
 */
public class ParserArrayStartedImpl implements Parser {
    private static final String TAG = ParserArrayStartedImpl.class.getSimpleName();
    private UnMarshalerTypes mUnMarshalerType;

    public ParserArrayStartedImpl(UnMarshalerTypes ad) {
        mUnMarshalerType = ad;
    }

    @Override
    public <T> T parse(Class<T> cls, String data) {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = null;
        rootObj = parse(cls, rootElement);
        return rootObj;
    }

    @Override
    public <T> T parse(Class<T> cls, InputStream data) {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = null;
        rootObj = parse(cls, rootElement);
        return rootObj;
    }


    private <T> T parse(Class<T> cls, ElementUnmarshaler rootElement) {
        T rootObj = null;
        //TODO change to Collection.class
        if (cls.isAssignableFrom(Collection.class)) {
            try {
                //XXX
                List<ElementUnmarshaler> children = rootElement.getChildren("sdfgsdfgsdfgsdfgsdf");
                rootObj = (T) new ArrayList();

                Class<?> genericClass = cls.getTypeParameters()[0].getGenericDeclaration();
                Object item = null;


                for (int i = 0; i < children.size(); i++) {
                    item = genericClass.newInstance();
                    ((Collection) rootObj).add(item);
                    processObject(item, children.get(i));
                }

            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        } else if (cls.isArray()) {
            //TODO Need to implement
            throw new UnsupportedOperationException();
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
            try {
                rootObj = cls.newInstance();
                processObject(rootObj, rootElement);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return rootObj;
    }


    protected void processObject(Object obj, ElementUnmarshaler elem) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            String xmlValue = "";

            if (field.isAnnotationPresent(XmlAttribute.class)) {
                String annotationName = field.getAnnotation(XmlAttribute.class).name();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, field, obj);
            } else if (field.isAnnotationPresent(XmlElement.class)) {

                boolean simpleTypeParsed = processSimpleValue(elem, field, obj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                }
            }
        }

    }

    /**
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementUnmarshaler elem, Field field, T obj) throws IllegalAccessException {
        String annotationName = field.getAnnotation(XmlElement.class).name();
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

    protected <T> void processComplexValue(ElementUnmarshaler elem, Field field, T obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(XmlElement.class).name();

        //TODO change to Collection.class
        if (valueType == Collection.class) {
            List<ElementUnmarshaler> children = elem.getChildren(annotName);
            List objects = new ArrayList();
            field.set(obj, objects);

            Type genericType = field.getGenericType();
            Object item = null;
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                for (int i = 0; i < children.size(); i++) {
                    item = tClass.newInstance();
                    objects.add(item);
                    processObject(item, children.get(i));
                }
            }
        } else if (valueType.isArray()) {
            //TODO Need to implement
            throw new UnsupportedOperationException();
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
            ElementUnmarshaler child = elem.getChild(annotName);
            Class<?> type = field.getType();
            Object childObj = type.newInstance();
            field.set(obj, childObj);
            processObject(childObj, child);
        }
    }


}
