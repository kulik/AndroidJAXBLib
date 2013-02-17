package biz.kulik.android.jaxb.library.parser;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.parser.chache.CacheEntity;
import biz.kulik.android.jaxb.library.parser.chache.ClassCacheManager;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldFactory;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshaler;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshalerFactory;
import biz.kulik.android.jaxb.library.parser.stringutil.SimpleParsersManager;
import biz.kulik.android.jaxb.library.parser.stringutil.SimpleTypeParser;

import java.io.InputStream;
import java.lang.reflect.*;
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
    private ClassCacheManager mClassCacheManager;

    public ParserImpl(UnMarshalerTypes ad) {
        mUnMarshalerType = ad;
//        xmlAdaptersManager = new AdaptersManager();
        mSimpleParsersManager = new SimpleParsersManager();
        mClassCacheManager = new ClassCacheManager();
    }

    @Override
    public <T> T parse(Class<T> cls, String data) {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = parse(cls, rootElement);
        return rootObj;
    }

    @Override
    public <T> T parse(Class<T> cls, InputStream data) {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = parse(cls, rootElement);
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
        processClassEntities(obj, clazz, elem, MethodFieldFactory.EntityType.FIELDS);
        processClassEntities(obj, clazz, elem, MethodFieldFactory.EntityType.METHODS);

    }

    private void processClassEntities(Object obj, Class<?> clazz, ElementUnmarshaler elem, MethodFieldFactory.EntityType entityType) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        List<CacheEntity> attributesEntity = mClassCacheManager.getChachedAttributesEntityList(clazz, entityType);
        List<CacheEntity> elementsEntity = mClassCacheManager.getChachedElementsEntityList(clazz, entityType);
        if (attributesEntity == null || elementsEntity == null) {
            MethodFieldAdapter[] allEntity;
            allEntity = MethodFieldFactory.getAllEntytyByType(clazz, entityType);

            attributesEntity = new ArrayList<CacheEntity>(allEntity.length % 3 * 2);
            elementsEntity = new ArrayList<CacheEntity>(allEntity.length % 3 * 2);

            MethodFieldAdapter methodfield;
            for (int i = 0, d = allEntity.length; i < d; i++) {
                methodfield = allEntity[i];

                if (methodfield.isAnnotationPresent(XmlAttribute.class)) {
                    String annotationName = methodfield.getAnnotation(XmlAttribute.class).name();
                    String xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                    processAtributeValue(xmlValue, methodfield, obj);
                    attributesEntity.add(new CacheEntity(methodfield, annotationName));

                } else if (methodfield.isAnnotationPresent(XmlElement.class)) {

                    String annotationName = methodfield.getAnnotation(XmlElement.class).name();
                    boolean simpleTypeParsed = processSimpleValue(elem, methodfield, annotationName, obj);
                    if (simpleTypeParsed == false) {
                        processComplexValue(elem, methodfield, annotationName, obj);
                    }
                    elementsEntity.add(new CacheEntity(methodfield, annotationName));
                }
            }
            mClassCacheManager.pushEntityToCache(clazz, attributesEntity, elementsEntity, entityType);
        } else {
            CacheEntity cacheEntity;
            String xmlValue;
            String annotationName;
            for (int i = 0, d = attributesEntity.size(); i < d; i++) {
                cacheEntity = attributesEntity.get(i);

                annotationName = cacheEntity.getXmlName();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, cacheEntity.getMethodField(), obj);
            }
            boolean simpleTypeParsed;
            for (int i = 0, d = elementsEntity.size(); i < d; i++) {
                cacheEntity = elementsEntity.get(i);
                simpleTypeParsed = processSimpleValue(elem, cacheEntity.getMethodField(), cacheEntity.getXmlName(), obj);
                if (!simpleTypeParsed) {
                    processComplexValue(elem, cacheEntity.getMethodField(), cacheEntity.getXmlName(), obj);
                }

            }
        }
    }

    /**
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementUnmarshaler elem, MethodFieldAdapter mfAdapter, String annotationName, T obj) throws IllegalAccessException, InvocationTargetException {

        String value = elem.getValue(annotationName);

        return processAtributeValue(value, mfAdapter, obj);
    }

    /**
     * @param value     String value from xml document
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processAtributeValue(String value, MethodFieldAdapter mfAdapter, T obj) throws IllegalAccessException, InvocationTargetException {

        mfAdapter.setAccessible(true); //TODO add accessorTypeLogic
        Class<?> valueType = mfAdapter.getType();
        if (String.class.equals(valueType)) {
            mfAdapter.put(obj, value);
            return true;
        } else {
            SimpleTypeParser simpleTypeParser = mSimpleParsersManager.getParser(valueType);
            //TODO  make it as Static Factory   ^^^^^^^^^^^^^^^^^^^^^
            if (simpleTypeParser != null) {
                mfAdapter.put(obj, simpleTypeParser.valueOf(value));
                return true;
            }
        }
        return false;
    }

    protected <T> void processComplexValue(ElementUnmarshaler elem, MethodFieldAdapter field, String annotName, T obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();

        //TODO change to Collection.class
        if (valueType == List.class) {
            List<ElementUnmarshaler> children = elem.getChildren(annotName);
            List objects = new ArrayList(children.size());
            field.put(obj, objects);

            Type genericType = field.getGenericParameterTypes();
//            Class<?> tClass = ReflectionUtils.getGenericParameterClass(List.class, field.getDeclaringClass(), 0);
            Object item = null;
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                for (int i = 0, d = children.size(); i < d; i++) {
                    item = tClass.newInstance();
                    objects.add(item);
                    processObject(item, tClass, children.get(i));
                }
            }

        } else if (valueType.isArray()) {
            //TODO Need to implement
            throw new UnsupportedOperationException("Array parsing not implemented yet, use List instaed");
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
            field.put(obj, childObj);
            processObject(childObj, type, child);
        }
    }

}
