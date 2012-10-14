package biz.mobidev.android.jaxb.library.composer;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations;
import biz.mobidev.android.jaxb.library.parser.ElementAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: kulik
 * Date: 10/03/12
 * Time: 23:12 PM
 */
public class ComposerImpl implements Composer {
    private static final String TAG = ComposerImpl.class.getSimpleName();
    private ProviderTypes mProviderType;

    public ComposerImpl(ProviderTypes ad) {
        mProviderType = ad;
    }

    @Override
    public UMO compose(Object data) {
        UMO rootElem = null;
        Class objType = data.getClass();
        try {
            if (objType == List.class) {
                List ourList = (List) data;
                rootElem = new UMOArray();//Array

                //Type genericType = field.getGenericType();
                for (Object itemObj : ourList) {

//                if (genericType instanceof ParameterizedType) {
//                    ParameterizedType paramType = (ParameterizedType) genericType;
//                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
//                    item = tClass.newInstance();
//                    objects.add(item);
//                }
                   rootElem.put(processObject(itemObj));
                }
            } else if (objType.isArray()) {
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
                rootElem = new UMOObject();
                ElementAdapter child = elem.getChild(annotName);
                Class<?> type = field.getType();
                Object childObj = type.newInstance();
                field.set(obj,childObj);
                processObject(childObj, child);
            }

            rootElem = processObject(data);

        } catch (InvocationTargetException e) {
            Log.e(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        }
        return rootElem;
    }
    protected Object processObject(Object obj) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        return processFields(obj);
        //processMethods(obj, sobj);
    }

    //TODO implement this line of tree
//    protected void processMethods(Object obj, UniversalMarshalObject sobj) throws IllegalArgumentException, IllegalAccessException,
//            InvocationTargetException {
//        Class<?> cl = obj.getClass();
//        Method[] allMethods = cl.getDeclaredMethods();
//        //	Log.v(TAG,"ProcessMethods quantity:" + allMethods.length);
//
//        for (Method method : allMethods) {
//            //	Log.v(TAG,"ProcessMethod field:" + method.getName()+ "; AnnotationPresent:" + method.isAnnotationPresent(ToSend.class));
//
//            if (method.isAnnotationPresent(ToSend.class)) {
//                method.setAccessible(true);
//                String key = method.getAnnotation(ToSend.class).name();
//                Object keyValue = method.invoke(obj);
//                processValue(keyValue, key, sobj); //obj,
//            }
//        }
//    }

    protected Object processFields(Object obj) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, JSONException {
        Object outObj = null;
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        //	Log.v(TAG,"ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            //	Log.v(TAG,"ProcessFields field:" + field.getName()+ "; AnnotationPresent:" + field.isAnnotationPresent(ToSend.class));
//            TODO if (field.isAnnotationPresent(Annotations.Attribute.class)) {
//                String annotationName = field.getAnnotation(Annotations.Attribute.class).name();
//                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
//                processAtributeValue(xmlValue, field, obj);
//            } else
            if (field.isAnnotationPresent(Annotations.Value.class)) {

                //boolean simpleTypeParsed = processSimpleValue(obj, field, sobj);
                //if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                //}

            }

            }

        return outObj;
    }

    protected boolean processSimpleValue(Object obj, Field field, JSONObject sobj) throws IllegalAccessException, JSONException {
        String annotationName = field.getAnnotation(Annotations.Value.class).name();
        String value;

        field.setAccessible(true);
        Class<?> valueType = field.getType();
        if (String.class.equals(valueType)) {
            sobj.put(annotationName, (String) field.get(obj));
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.put(annotationName, field.getInt(obj));
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.put(annotationName, field.getLong(obj));
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.put(annotationName, field.getFloat(obj));
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.put(annotationName, field.getFloat(obj));
            return true;
        }
        return false;
    }

    protected void processComplexValue(Object obj, Field field, JSONObject sobj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException, JSONException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(Annotations.Value.class).name();

        if (valueType == List.class) {
            JSONArray sarray = new JSONArray();
            sobj.put(annotName, sarray);

            List objects = (List) field.get(obj);

            //Type genericType = field.getGenericType();
            for (Object itemObj : objects) {

//                if (genericType instanceof ParameterizedType) {
//                    ParameterizedType paramType = (ParameterizedType) genericType;
//                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
//                    item = tClass.newInstance();
//                    objects.add(item);
//                }
                sitem = new JSONArray()
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
