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
package com.kulik.android.jaxb.library.parser;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import com.kulik.android.jaxb.library.Annotations.XmlValue;
import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapterTypesException;
import com.kulik.android.jaxb.library.ExeptionUtil;
import com.kulik.android.jaxb.library.adapters.AdapterException;
import com.kulik.android.jaxb.library.adapters.AdaptersManager;
import com.kulik.android.jaxb.library.loger.Log;
import com.kulik.android.jaxb.library.parser.chache.CacheEntity;
import com.kulik.android.jaxb.library.parser.chache.CacheWrapperEntity;
import com.kulik.android.jaxb.library.parser.chache.ChacheEntities;
import com.kulik.android.jaxb.library.parser.chache.ClassCacheManager;
import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;
import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldFactory;
import com.kulik.android.jaxb.library.parser.providers.ElementUnmarshaler;
import com.kulik.android.jaxb.library.parser.providers.ElementUnmarshalerFactory;
import com.kulik.android.jaxb.library.parser.stringutil.SimpleParsersManager;
import com.kulik.android.jaxb.library.parser.stringutil.SimpleTypeParser;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: kulik
 * <p/>
 * Date: 11/23/12
 * Time: 10:45 AM
 */
public class ParserImpl implements Parser {
    private static final String TAG = ParserImpl.class.getSimpleName();

    private UnMarshalerTypes mUnMarshalerType;

    private AdaptersManager mJavaAdaptersManager;
    ChacheEntities mChacheEntities;

    public ParserImpl(UnMarshalerTypes ad) {
        mUnMarshalerType = ad;
        mJavaAdaptersManager = new AdaptersManager(AdaptersManager.ManagerType.PARSER);
       mChacheEntities = new ChacheEntities();
    }

    @Override
    public <T> T parse(Class<T> cls, String data) throws Exception {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = parse(cls, rootElement);
        return rootObj;
    }

    @Override
    public <T> T parse(Class<T> cls, InputStream data) throws Exception {
        ElementUnmarshaler rootElement = ElementUnmarshalerFactory.createAdapter(mUnMarshalerType, data);
        T rootObj = parse(cls, rootElement);
        return rootObj;
    }

    private <T> T parse(Class<T> cls, ElementUnmarshaler rootElement) throws Exception {
        T rootObj = null;
        try {
            rootObj = cls.newInstance();
        } catch (IllegalAccessException e) {
            ExeptionUtil.processInstantiationExceptions(e, cls);
        }
        try {
            processObject(rootObj, cls, rootElement);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "InvocationTargetException while parsing: " + e.getMessage(), e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException while parsing: " + e.getMessage(), e);
        } catch (InstantiationException e) {
            Log.e(TAG, "InstantiationException while parsing: " + e.getMessage());
            Log.e(TAG, "It may caused missing defoult constructor", e);
        } catch (AdapterException e) {
            throw e.getAdapterException();
        }
        return rootObj;
    }

    //TODO mast be refactored exclude logic from chache
    protected void processObject(Object obj, Class<?> clazz, ElementUnmarshaler elem) throws AdapterException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Class<?> cl = obj.getClass();
        processClassEntities(obj, clazz, elem, MethodFieldFactory.EntityType.FIELDS);
        processClassEntities(obj, clazz, elem, MethodFieldFactory.EntityType.METHODS);

    }

    private void processClassEntities(Object obj, Class<?> clazz, ElementUnmarshaler elem, MethodFieldFactory.EntityType entityType) throws XmlAdapterTypesException, IllegalAccessException, AdapterException, InvocationTargetException, InstantiationException {

        ChacheEntities.Chache chache = mChacheEntities.getChacheForClass(clazz, entityType);

        if (chache == null) {
            MethodFieldAdapter[] allEntity;
            allEntity = MethodFieldFactory.getAllEntytyByType(clazz, entityType);
            chache = mChacheEntities.initChacheForClass(clazz, entityType);

            MethodFieldAdapter methodfield;
            for (int i = 0, d = allEntity.length; i < d; i++) {
                methodfield = allEntity[i];
                processMethodField(methodfield, elem, chache, false, obj/*, clazz, entityType*/);
            }
            mChacheEntities.push(chache, clazz, entityType);
        } else {    //if class entites already chached
            CacheEntity cacheEntity;
            String xmlValue;
            String annotationName;
            MethodFieldAdapter methodField;
            String ns;
            List<CacheEntity> attributesEntity = chache.getAttributesEntity();
            for (int i = 0, d = attributesEntity.size(); i < d; i++) {
                cacheEntity = attributesEntity.get(i);
                methodField = cacheEntity.getMethodField();
                annotationName = cacheEntity.getXmlName();
                ns = cacheEntity.getNS();
                xmlValue = elem.getAttributeValue(annotationName, ns);   //Retrieves an attribute value by name.

                processAtributeValue(xmlValue, methodField, obj);
            }

            List<CacheEntity> valuesEntity = chache.getValuesEntity();
            for (int i = 0, d = valuesEntity.size(); i < d; i++) {
                cacheEntity = valuesEntity.get(i);
                methodField = cacheEntity.getMethodField();
                processValue(elem, methodField, obj);
            }
            boolean simpleTypeParsed;
            List<CacheEntity> elementsEntity = chache.getElementsEntity();
            for (int i = 0, d = elementsEntity.size(); i < d; i++) {
                cacheEntity = elementsEntity.get(i);
                methodField = cacheEntity.getMethodField();
                annotationName = cacheEntity.getXmlName();
                ns = cacheEntity.getNS();
                methodField.setAccessible(true); //TODO add accessorTypeLogic

                Class<?> originValueType = methodField.getInputType();
                XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(methodField);
                Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(adapter);
                if (!(Object.class.equals(adapterValueType))) {
                    originValueType = adapterValueType;
                }
                simpleTypeParsed = processSimpleValue(elem, methodField, annotationName, ns, obj, originValueType, adapter);
                if (!simpleTypeParsed) {
                    processComplexValue(elem, methodField, annotationName, ns, obj, originValueType, adapter);
                }
            }
            CacheWrapperEntity wrapperEntity;

            List<CacheWrapperEntity> wrappersEntity = chache.getWrappersEntity();
            for (int i = 0, d = wrappersEntity.size(); i < d; i++) {
                wrapperEntity = wrappersEntity.get(i);
                String wrapperName = wrapperEntity.getXmlWrapper();
                String wrapperNS = wrapperEntity.getNSWrapper();
                String elementName = wrapperEntity.getXmlName();
                ns = wrapperEntity.getNS();

                methodField = wrapperEntity.getMethodField();
                methodField.setAccessible(true); //TODO add accessorTypeLogic
                Class<?> originValueType = methodField.getInputType();

                XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(methodField);
                Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(adapter);
                if (!(Object.class.equals(adapterValueType))) {
                    originValueType = adapterValueType;
                }

                ElementUnmarshaler elemWrapped = elem.getChild(wrapperName, wrapperNS);
                if (elemWrapped != null) {
                    simpleTypeParsed = processSimpleValue(elemWrapped, methodField, elementName, ns, obj, originValueType, adapter);
                    if (!simpleTypeParsed) {
                        processComplexValue(elemWrapped, methodField, elementName, ns, obj, originValueType, adapter);
                    }
                }
            }
        }
    }

    private void processMethodField(MethodFieldAdapter methodField, ElementUnmarshaler elem,
                                    ChacheEntities.Chache chache,
                                    boolean isWrapped,
                                    Object obj
//            ,
//                                    Class<?> clazz,
//                                    MethodFieldFactory.EntityType entityType
    ) throws XmlAdapterTypesException, InvocationTargetException, IllegalAccessException, AdapterException, InstantiationException {

        if (methodField.isAnnotationPresent(XmlValue.class)) {
            processValue(elem, methodField, obj);
            chache.getValuesEntity().add(new CacheEntity(methodField, null, null));

        } else if (methodField.isAnnotationPresent(XmlAttribute.class)) {
            XmlAttribute xmlAttribute = methodField.getAnnotation(XmlAttribute.class);
            String annotationName = xmlAttribute.name();
            String ns = xmlAttribute.namespace();
            String xmlValue = elem.getAttributeValue(annotationName, ns);   //Retrieves an attribute value by name.
            processAtributeValue(xmlValue, methodField, obj);
            chache.getAttributesEntity().add(new CacheEntity(methodField, annotationName, ns));

        } else if (!isWrapped && methodField.isAnnotationPresent(XmlElementWrapper.class)) {
            XmlElementWrapper xmlElementWrapper = methodField.getAnnotation(XmlElementWrapper.class);
            String wrapperName = xmlElementWrapper.name();
            String wrapperNS = xmlElementWrapper.namespace();
            ElementUnmarshaler elemWrapped = elem.getChild(wrapperName, wrapperNS);
            if (elemWrapped != null) {
                processMethodField(methodField, elemWrapped, chache, true, obj/*, clazz, entityType*/);
            }
//          TODO  elementsEntity.add(new CacheEntity(methodField, annotationName));
            XmlElement annotation = methodField.getAnnotation(XmlElement.class);
            String elementName = annotation.name();
            String elementNS = annotation.namespace();
            chache.getWrappersEntity().add(new CacheWrapperEntity(methodField, elementName, elementNS, wrapperName, wrapperNS));

        } else if (methodField.isAnnotationPresent(XmlElement.class)) {
            XmlElement xmlElement = methodField.getAnnotation(XmlElement.class);
            String annotationName = xmlElement.name();
            String ns = xmlElement.namespace();

            methodField.setAccessible(true); //TODO add accessorTypeLogic
            Class<?> originValueType = methodField.getInputType();

            XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(methodField);
//            XmlAdapter.checkAdapterCompatibility(adapter, originValueType);

            Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(adapter);
            if (!(adapterValueType.equals(Object.class))) {
                originValueType = adapterValueType;
            }
            //process Java  Type Wrappers (Boolean, Integer, Float etc.)
            boolean simpleTypeParsed = processSimpleValue(elem, methodField, annotationName, ns, obj, originValueType, adapter);
            if (simpleTypeParsed == false) {
                processComplexValue(elem, methodField, annotationName, ns, obj, originValueType, adapter);
            }
            if (!isWrapped) { // item already exist in wrapper chache
                chache.getElementsEntity().add(new CacheEntity(methodField, annotationName, ns));
            }
        }
    }

    private void processValue(ElementUnmarshaler elem, MethodFieldAdapter methodField, Object obj) throws AdapterException, InvocationTargetException, IllegalAccessException {
        methodField.setAccessible(true);
        Class<?> originValueType = methodField.getInputType();
        XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(methodField);
        Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(adapter);
        if (!(Object.class.equals(adapterValueType))) {
            originValueType = adapterValueType;
        }
        SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(originValueType);
        if (simpleTypeParser != null) {
            String value = elem.getValue();
            Object preParsed = (value != null) ? simpleTypeParser.valueOf(value) : null;
            if (simpleTypeParser.isPrimitiveType() && preParsed == null) {
                Log.e(TAG, "parsing methodField:" + methodField + " failed on value: " + value);
            }
            methodField.put(obj, XmlAdapter.unmarshal(adapter, preParsed));
        }
    }

    /**
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @param valueType Type for parsing from XML
     * @param adapter   XMLAdapter
     * @throws IllegalAccessException
     */
    protected <T> boolean processSimpleValue(ElementUnmarshaler elem, MethodFieldAdapter mfAdapter, String valueName, String ns, T obj, Class<?> valueType, XmlAdapter adapter) throws IllegalAccessException, InvocationTargetException, AdapterException {
        SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(valueType);
        if (simpleTypeParser != null) {
            String value = elem.getValue(valueName, ns);
            Object preParsed = (value != null) ? simpleTypeParser.valueOf(value) : null;
            if (simpleTypeParser.isPrimitiveType() && preParsed == null) {
                Log.e(TAG, "parsing methodField:" + mfAdapter + " failed on value: " + value);
            }
            mfAdapter.put(obj, XmlAdapter.unmarshal(adapter, preParsed));
            return true;
        }
        return false;
    }

    /**
     * @param value     String value from xml document
     * @param mfAdapter Method or Field adapter of object where to put value
     * @param obj       Object which field will be set
     * @throws IllegalAccessException, InvocationTargetException
     */
    protected <T> boolean processAtributeValue(String value, MethodFieldAdapter mfAdapter, T obj) throws IllegalAccessException, InvocationTargetException, AdapterException {
        //TODO get velue after checking
        mfAdapter.setAccessible(true); //TODO add accessorTypeLogic
        Class<?> originValueType = mfAdapter.getInputType();
        XmlAdapter adapter = mJavaAdaptersManager.getAdapterForField(mfAdapter);
        Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(adapter);
        if (!Object.class.equals(adapterValueType)) {
            originValueType = adapterValueType;
        }
        SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(originValueType);
        if (simpleTypeParser != null) {
            Object parsedValue = (value != null) ? simpleTypeParser.valueOf(value) : null;
            if (simpleTypeParser.isPrimitiveType() && parsedValue == null) {
                Log.e(TAG, "parsing methodField:" + mfAdapter + " failed on value: " + value);
            }
            Object adaptedValue = XmlAdapter.unmarshal(adapter, parsedValue);
            mfAdapter.put(obj, adaptedValue);
            return true;
        }
        return false;
    }

    protected <T> void processComplexValue(ElementUnmarshaler elem, MethodFieldAdapter methodField, String annotName, String ns, T obj, Class<?> originValueType, XmlAdapter adapter) throws AdapterException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //TODO change to Collection.class
        if (originValueType == List.class) {
            List<ElementUnmarshaler> children = elem.getChildren(annotName, ns);
            List objects = new ArrayList(children.size());

            Type genericType = methodField.getGenericParameterTypes();
//            Class<?> tClass = ReflectionUtils.getGenericParameterClass(List.class, methodField.getDeclaringClass(), 0);
            Object preParsedItem = null;
            if (genericType instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) genericType;
                Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];

                XmlAdapter itemAdapter = mJavaAdaptersManager.getAdapterByProp(methodField.getPackage(), methodField.getClassClass(), tClass);
                Class<?> adapterValueType = XmlAdapter.getUnMarshalerType(itemAdapter);
                if (!Object.class.equals(adapterValueType)) {
                    tClass = adapterValueType;
                }
                if (String.class.equals(tClass)) {
//TODO create stub SIMPLEPARSER for String
                    for (int i = 0, d = children.size(); i < d; i++) {
                        preParsedItem = children.get(i).getValue();
                        objects.add(XmlAdapter.unmarshal(itemAdapter, preParsedItem));
                    }
                } else {
                    SimpleTypeParser simpleTypeParser = SimpleParsersManager.getParser(originValueType);
                    if (simpleTypeParser != null) {
                        for (int i = 0, d = children.size(); i < d; i++) {
                            preParsedItem = simpleTypeParser.valueOf(children.get(i).getValue(annotName, ns));
                            objects.add(XmlAdapter.unmarshal(itemAdapter, preParsedItem));
                        }
                    } else {
                        for (int i = 0, d = children.size(); i < d; i++) {
                            preParsedItem = tClass.newInstance();
                            processObject(preParsedItem, tClass, children.get(i));
                            objects.add(XmlAdapter.unmarshal(itemAdapter, preParsedItem));
                        }
                    }
                }
            }
            methodField.put(obj, XmlAdapter.unmarshal(adapter, objects));
        } else if (originValueType.isArray()) {
            //TODO Need to implement
            throw new UnsupportedOperationException("Array parsing not implemented yet, use List instaed");
        } else {
            if (elem.isChildExist(annotName, ns)) {
                ElementUnmarshaler child = elem.getChild(annotName, ns);
                Object childObj = originValueType.newInstance();
                processObject(childObj, originValueType, child);
                methodField.put(obj, XmlAdapter.unmarshal(adapter, childObj));
            }
        }
    }

}