package biz.mobidev.android.jaxb.library.parser;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations;

import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 11:09 AM
 */
public class ParserImpl<T> implements Parser<T> {
    private static final String TAG = ParserImpl.class.getSimpleName();
    private AdapterTypes mAdapterType;

    public ParserImpl(AdapterTypes ad) {
        mAdapterType = ad;
    }

//    @Override
//    public T parse(Class cls, InputStream data) {
//        Document doc = toDocument(data);
//        return parse(cls, doc);
//    }

//    @Override
//    public T parse(Class cls, String data) {
//        InputStream dat = new ByteArrayInputStream(data.getBytes());
//        Document doc = toDocument(dat);
//        T parsedObj = parse(cls, doc);
//        return  parsedObj;
//    }

    //XXX input point
    public T parse(Class cls, InputStream data) {
        ElementAdapter rootElement = ElementAdapterFactory.createAdapter(mAdapterType, data);
        T rootObj = null;
        try {
            rootObj = (T) cls.newInstance();
            processObject(rootObj, rootElement);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "InvocationTargetException while parcing: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException while parcing: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, "InstantiationException while parcing: " + e.getMessage());
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

            if (field.isAnnotationPresent(Annotations.Attribute.class)) {
                String annotationName = field.getAnnotation(Annotations.Attribute.class).name();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, field, obj);
            } else if (field.isAnnotationPresent(Annotations.Value.class)) {

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
    protected boolean processSimpleValue(ElementAdapter elem, Field field, Object obj) throws IllegalAccessException{
        String annotationName = field.getAnnotation(Annotations.Value.class).name();
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
        }
        return false;
    }


    /**
     * @param value String value from xml document
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected boolean processAtributeValue(String value, Field field, Object obj) throws IllegalAccessException {
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
        }
        return false;
    }

    protected void processComplexValue(ElementAdapter elem, Field field, Object obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(Annotations.Value.class).name();

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
