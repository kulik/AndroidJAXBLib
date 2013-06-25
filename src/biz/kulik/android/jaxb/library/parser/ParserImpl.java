package biz.kulik.android.jaxb.library.parser;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parser.adapters.AdaptersManager;
import biz.kulik.android.jaxb.library.parser.chache.CacheEntity;
import biz.kulik.android.jaxb.library.parser.chache.CacheWrapperEntity;
import biz.kulik.android.jaxb.library.parser.chache.ClassCacheManager;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldFactory;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshaler;
import biz.kulik.android.jaxb.library.parser.providers.ElementUnmarshalerFactory;
import biz.kulik.android.jaxb.library.parser.stringutil.SimpleParsersManager;
import biz.kulik.android.jaxb.library.parser.stringutil.SimpleTypeParser;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: kulik
 * Date: 11/23/12
 * Time: 10:45 AM
 */
public class ParserImpl implements Parser {
    private static final String TAG = ParserImpl.class.getSimpleName();

    private UnMarshalerTypes mUnMarshalerType;

    private AdaptersManager mJavaAdaptersManager;

    private ClassCacheManager mClassCacheManager;

    public ParserImpl(UnMarshalerTypes ad) {
        mUnMarshalerType = ad;
        mJavaAdaptersManager = new AdaptersManager();
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
            Log.e(TAG, "It may caused missing defoult constructor");
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
        List<CacheWrapperEntity> wrappersEntity = mClassCacheManager.getChachedWrappedElementsEntityList(clazz, entityType);

        if (attributesEntity == null || elementsEntity == null || elementsEntity == null) {
            MethodFieldAdapter[] allEntity;
            allEntity = MethodFieldFactory.getAllEntytyByType(clazz, entityType);

            attributesEntity = new LinkedList<CacheEntity>();//allEntity.length % 3 * 2);
            elementsEntity = new LinkedList<CacheEntity>();
            wrappersEntity = new LinkedList<CacheWrapperEntity>();//2

            MethodFieldAdapter methodfield;
            for (int i = 0, d = allEntity.length; i < d; i++) {
                methodfield = allEntity[i];
                processMethodField(methodfield, elem, attributesEntity, elementsEntity, wrappersEntity, false, obj, clazz, entityType);
            }
            mClassCacheManager.pushEntityToCache(clazz, attributesEntity, elementsEntity, wrappersEntity, entityType);
        } else {    //if class entites already chached
            CacheEntity cacheEntity;
            String xmlValue;
            String annotationName;
            MethodFieldAdapter methodField;
            for (int i = 0, d = attributesEntity.size(); i < d; i++) {
                cacheEntity = attributesEntity.get(i);
                methodField = cacheEntity.getMethodField();
                annotationName = cacheEntity.getXmlName();
                xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.

                processAtributeValue(xmlValue, methodField, obj);
            }
            boolean simpleTypeParsed;
            for (int i = 0, d = elementsEntity.size(); i < d; i++) {
                cacheEntity = elementsEntity.get(i);
                methodField = cacheEntity.getMethodField();
                annotationName = cacheEntity.getXmlName();

                simpleTypeParsed = processSimpleValue(elem, methodField, annotationName, obj);
                if (!simpleTypeParsed) {
                    processComplexValue(elem, methodField, annotationName, obj);
                }
            }
            CacheWrapperEntity wraperEntity;
            for (int i = 0, d = wrappersEntity.size(); i < d; i++) {
                wraperEntity = wrappersEntity.get(i);
                String wrapperName = wraperEntity.getXmlWrapper();
                String elementName = wraperEntity.getXmlName();
                methodField = wraperEntity.getMethodField();

                ElementUnmarshaler elemWrapped = elem.getChild(wrapperName);
                simpleTypeParsed = processSimpleValue(elemWrapped, methodField, elementName, obj);
                if (!simpleTypeParsed) {
                    processComplexValue(elemWrapped, methodField, elementName, obj);
                }
            }
        }
    }

    private void processMethodField(MethodFieldAdapter methodfield, ElementUnmarshaler elem,
                                    List<CacheEntity> attributesEntity,
                                    List<CacheEntity> elementsEntity,
                                    List<CacheWrapperEntity> wrappersEntity,
                                    boolean isWrapped,
                                    Object obj,
                                    Class<?> clazz,
                                    MethodFieldFactory.EntityType entityType) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        if (methodfield.isAnnotationPresent(XmlAttribute.class)) {
            String annotationName = methodfield.getAnnotation(XmlAttribute.class).name();
            String xmlValue = elem.getAttributeValue(annotationName);   //Retrieves an attribute value by name.
            processAtributeValue(xmlValue, methodfield, obj);
            attributesEntity.add(new CacheEntity(methodfield, annotationName));

        } else if (!isWrapped && methodfield.isAnnotationPresent(XmlElementWrapper.class)) {
            String wrapperName = methodfield.getAnnotation(XmlElementWrapper.class).name();
            ElementUnmarshaler elemWrapped = elem.getChild(wrapperName);
            processMethodField(methodfield, elemWrapped, attributesEntity, elementsEntity, wrappersEntity, true, obj, clazz, entityType);
//                  TODO  elementsEntity.add(new CacheEntity(methodfield, annotationName));
            String elementName = methodfield.getAnnotation(XmlElement.class).name();
            wrappersEntity.add(new CacheWrapperEntity(methodfield, elementName, wrapperName));

        } else if (methodfield.isAnnotationPresent(XmlElement.class)) {
            String annotationName = methodfield.getAnnotation(XmlElement.class).name();
            XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(methodfield);
            //process Java  Type Wrappers (Boolean, Integer, Float etc.)
            boolean simpleTypeParsed = processSimpleValue(elem, methodfield, annotationName, obj);
            if (simpleTypeParsed == false) {
                processComplexValue(elem, methodfield, annotationName, obj);
            }
            if (!isWrapped) { // item already exist in wrapper chache
                elementsEntity.add(new CacheEntity(methodfield, annotationName));
            }
        }
    }

    /**
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementUnmarshaler elem, MethodFieldAdapter mfAdapter, String valueName, T obj) throws IllegalAccessException, InvocationTargetException {
        mfAdapter.setAccessible(true); //TODO add accessorTypeLogic
        Class<?> valueType = mfAdapter.getType();
        SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(valueType);
        if (simpleTypeParser != null) {
            String value = elem.getValue(valueName);
            mfAdapter.put(obj, simpleTypeParser.valueOf(value));
            return true;
        }
        return false;
    }

    /**
     * @param value     String value from xml document
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @throws IllegalAccessException
     */
    protected <T> boolean processAtributeValue(String value, MethodFieldAdapter mfAdapter, T obj) throws IllegalAccessException, InvocationTargetException {
        //TODO get velue after checking

        mfAdapter.setAccessible(true); //TODO add accessorTypeLogic
        Class<?> valueType = mfAdapter.getType();
        SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(valueType);
        if (simpleTypeParser != null) {
            mfAdapter.put(obj, simpleTypeParser.valueOf(value));
            return true;
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

            Type genericType = field.getGenericParameterTypes();
//            Class<?> tClass = ReflectionUtils.getGenericParameterClass(List.class, field.getDeclaringClass(), 0);
            Object item = null;
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];

                //XXX problem here
//                    processObject(item, tClass, children.get(i));

                if (String.class.equals(tClass)) {
//TODO create stub SIMPLEPARSER for String
                    for (int i = 0, d = children.size(); i < d; i++) {
                        objects.add(children.get(i).getValue());
                    }
                } else {
                    SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(valueType);
                    if (simpleTypeParser != null) {
                        for (int i = 0, d = children.size(); i < d; i++) {
                            objects.add(simpleTypeParser.valueOf(children.get(i).getValue(annotName)));
                        }
                    } else {
                        for (int i = 0, d = children.size(); i < d; i++) {
                            item = tClass.newInstance();
                            objects.add(item);
                            processObject(item, tClass, children.get(i));
                        }
                    }
                }
            }
            field.put(obj, objects);
        } else if (valueType.isArray()) {
            //TODO Need to implement
            throw new UnsupportedOperationException("Array parsing not implemented yet, use List instaed");
        } else {
            if (elem.isChildExist(annotName)) {
                ElementUnmarshaler child = elem.getChild(annotName);
                Class<?> type = field.getType();
                Object childObj = type.newInstance();
                field.put(obj, childObj);
                processObject(childObj, type, child);
            }
        }
    }

}