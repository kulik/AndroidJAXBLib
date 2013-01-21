package biz.kulik.android.jaxb.library.parser;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.parser.chache.ChacheField;
import biz.kulik.android.jaxb.library.parser.chache.ClassChacheManager;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshaler;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshalerFactory;
import biz.kulik.android.jaxb.library.parser.stringutil.SimpleParsersManager;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * User: kulik
 * Date: 11/23/12
 * Time: 10:45 AM
 */
public class ParserImpl implements Parser {
    private static final String TAG = ParserImpl.class.getSimpleName();

    private UnMarshalerTypes mUnMarshalerType;

    //    private AdaptersManager xmlAdaptersManager;
    private SimpleParsersManager mSimpleParsersManager;
    private ClassChacheManager mClassChacheManager;

    public ParserImpl(UnMarshalerTypes ad) {
        mUnMarshalerType = ad;
//        xmlAdaptersManager = new AdaptersManager();
        mSimpleParsersManager = new SimpleParsersManager();
        mClassChacheManager = new ClassChacheManager();
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
        try {
            rootObj = cls.newInstance();
            processObject(rootObj, cls, rootElement);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "InvocationTargetException while parsing: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException while parsing: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, "InstantiationException while parsing: " + e.getMessage());
        }
        return rootObj;
    }

    //TODO mast be refactored exclude logic from chache
    protected void processObject(Object obj, Class<?> clazz, ElementUnmarshaler elem) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        //Class<?> cl = obj.getClass();
        List<ChacheField> attributesFields = mClassChacheManager.getChachedAttributesFieldList(clazz);
        List<ChacheField> elementsFields = mClassChacheManager.getChachedElementsFieldList(clazz);

        Field[] allFields;
        if (attributesFields == null || elementsFields == null) {
            allFields = clazz.getDeclaredFields();
            attributesFields = new ArrayList<ChacheField>(allFields.length % 2);
            elementsFields = new ArrayList<ChacheField>(allFields.length % 2);

            for (Field field : allFields) {
                // Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());

                if (field.isAnnotationPresent(XmlAttribute.class)) {
                    String annotationName = field.getAnnotation(XmlAttribute.class).name();
                    String xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                    processAtributeValue(xmlValue, field, obj);
                    attributesFields.add(new ChacheField(field, annotationName));

                } else if (field.isAnnotationPresent(XmlElement.class)) {

                    String annotationName = field.getAnnotation(XmlElement.class).name();
                    boolean simpleTypeParsed = processSimpleValue(elem, field, annotationName, obj);
                    if (simpleTypeParsed == false) {
                        processComplexValue(elem, field, annotationName, obj);
                    }
                    elementsFields.add(new ChacheField(field, annotationName));
                }
            }
            mClassChacheManager.pushFieldsToCache(clazz, attributesFields, elementsFields);
        } else {
            for (ChacheField chacheField : attributesFields) {
                // Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
                String xmlValue = "";

                String annotationName = chacheField.getXmlName();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, chacheField.getField(), obj);
            }
            for (ChacheField field : elementsFields) {

                boolean simpleTypeParsed = processSimpleValue(elem, field.getField(), field.getXmlName(), obj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field.getField(), field.getXmlName(), obj);
                }

            }
        }
    }

    /**
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementUnmarshaler elem, Field field, String annotationName, T obj) throws IllegalAccessException {

        String value = elem.getValue(annotationName);

        return processAtributeValue(value, field, obj);
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
            field.set(obj, mSimpleParsersManager.getParser(Integer.class).valueOf(value));
            return true;
        } else if (Long.class.equals(valueType)) {
            field.set(obj, mSimpleParsersManager.getParser(Long.class).valueOf(value));
            return true;
        } else if (Float.class.equals(valueType)) {
            field.set(obj, mSimpleParsersManager.getParser(Float.class).valueOf(value));
            return true;
        } else if (Double.class.equals(valueType)) {
            field.set(obj, mSimpleParsersManager.getParser(Double.class).valueOf(value));
            return true;
        } else if (Boolean.class.equals(valueType)) {
            field.set(obj, mSimpleParsersManager.getParser(Boolean.class).valueOf(value));
            return true;
        } else if (BigDecimal.class.equals(valueType)) {
            field.set(obj, mSimpleParsersManager.getParser(BigDecimal.class).valueOf(value));
            return true;
        }
        return false;
    }

    protected <T> void processComplexValue(ElementUnmarshaler elem, Field field, String annotName, T obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();

        //TODO change to Collection.class
        if (valueType == List.class) {
            List<ElementUnmarshaler> children = elem.getChildren(annotName);
            List objects = new ArrayList(children.size());
            field.set(obj, objects);

            Type genericType = field.getGenericType();
//            Class<?> tClass = ReflectionUtils.getGenericParameterClass(List.class, field.getDeclaringClass(), 0);
            Object item = null;
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                for (int i = 0; i < children.size(); i++) {
                    item = tClass.newInstance();
                    objects.add(item);
                    processObject(item, tClass, children.get(i));
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
            processObject(childObj, type, child);
        }
    }


}
