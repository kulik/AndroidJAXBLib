package biz.kulik.android.jaxb.library.composer;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import biz.kulik.android.jaxb.library.Annotations.XmlRootElement;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.adapters.AdapterException;
import biz.kulik.android.jaxb.library.adapters.AdaptersManager;
import biz.kulik.android.jaxb.library.composer.providers.ProviderFactory;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.FieldAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User: kulik
 * Date: 10/03/12
 * Time: 23:12 PM
 */
public class ComposerImpl implements Composer {
    private static final String TAG = ComposerImpl.class.getSimpleName();
    private ProviderFactory mFactory;
    private AdaptersManager mJavaAdaptersManager;

    public ComposerImpl(ProviderTypes ad) {
        mFactory = new ProviderFactory(ad);
        mJavaAdaptersManager = new AdaptersManager(AdaptersManager.ManagerType.COMPOSER);
    }

    @Override
    public UMO compose(Object data) throws AdapterException {
        UMO rootElem = null;
        rootElem = processObject(data, "", null);
        return rootElem;
    }

    protected UMO processObject(Object obj, String valueName, Class<?> ownerClass) throws AdapterException {
        UMO myElem = null;
        Object adaptObj = mJavaAdaptersManager.adaptMarshal(obj,obj.getClass().getPackage(), ownerClass);
        Class<?> adaptObjClass = adaptObj.getClass();
        try {
            if (adaptObj != null) {
                String root = "";
                if (adaptObjClass.isAnnotationPresent(XmlRootElement.class)) {
                    root = ((XmlRootElement) adaptObjClass.getAnnotation(XmlRootElement.class)).name();
                }
                //TODO need changed to Collection.class
                if (adaptObjClass.isAssignableFrom(List.class)) {
//                    List ourList = (List) obj;
                    List ourList = (List) adaptObj;

                    myElem = mFactory.createProvider(UMOArray.class, root);
                    //TODO Wrapper
                    for (int i = 0, d = ourList.size(); i < d; i++) {
                        UMO item = processObject(ourList.get(i), "".equals(valueName) ? root : valueName, adaptObjClass);
                        //TODO check if simple type
                        ((UMOArray) myElem).put("", item);
                    }
                } else if (adaptObjClass.isArray()) {
                    //TODO Need to implement
                } else {
                    myElem = mFactory.createProvider(UMOObject.class, "".equals(valueName) ? root : valueName);
                    processObjectContent(adaptObj, (UMOObject) myElem, adaptObjClass.getPackage(), null);
                }
            }
        } catch (InvocationTargetException e) {
            Log.e(TAG, e.getMessage(), e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage(), e);
        } catch (InstantiationException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return myElem;

    }

    private void processObjectContent(Object obj, UMOObject sobj, Package pack, Class<?> ownerClass) throws IllegalAccessException, InvocationTargetException, InstantiationException, AdapterException {
        processFields(obj, sobj, pack, ownerClass);
        //processMethods();
    }

    private boolean processAtributeValue(Object value, String annotationName, UMOObject sobj) {

        Class<?> valueType = value.getClass();
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

    protected boolean processSimpleValue(Object value, String valueName, UMOObject sobj) {

        Class<?> valueType = value.getClass();
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

    protected boolean processPrimitiveValue(Field field, Object obj, String valueName, UMOObject sobj) throws IllegalAccessException {

        Class<?> valueType = field.getType();
        if (Integer.TYPE.equals(valueType)) {
            sobj.putValueInt(valueName, field.getInt(obj));
            return true;
        } else if (Long.TYPE.equals(valueType)) {
            sobj.putValueLong(valueName, field.getLong(obj));
            return true;
        } else if (Float.TYPE.equals(valueType)) {
            sobj.putValueFloat(valueName, field.getFloat(obj));
            return true;
        } else if (Double.TYPE.equals(valueType)) {
            sobj.putValueDouble(valueName, field.getDouble(obj));
            return true;
        } else if (Boolean.TYPE.equals(valueType)) {
            sobj.putValueBoolean(valueName, field.getBoolean(obj));
            return true;
        }
        return false;
    }

    protected boolean processPrimitiveAttributes(Field field, Object obj, String valueName, UMOObject sobj) throws IllegalAccessException {

        Class<?> valueType = field.getType();
        if (Integer.TYPE.equals(valueType)) {
            sobj.putAttributeInt(valueName, field.getInt(obj));
            return true;
        } else if (Long.TYPE.equals(valueType)) {
            sobj.putAttributeLong(valueName, field.getLong(obj));
            return true;
        } else if (Float.TYPE.equals(valueType)) {
            sobj.putAttributeFloat(valueName, field.getFloat(obj));
            return true;
        } else if (Double.TYPE.equals(valueType)) {
            sobj.putAttributeDouble(valueName, field.getDouble(obj));
            return true;
        } else if (Boolean.TYPE.equals(valueType)) {
            sobj.putAttributeBoolean(valueName, field.getBoolean(obj));
            return true;
        }
        return false;
    }

    protected void processFields(Object obj, UMOObject sobj, Package pack, Class<?> ownerClass) throws IllegalAccessException, InvocationTargetException, InstantiationException, AdapterException {
        Object adaptObj = mJavaAdaptersManager.adaptMarshal(obj, pack, ownerClass);
        Class<?> adaptObjClass = adaptObj.getClass();

        Field[] allFields = adaptObjClass.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            field.setAccessible(true);

//            Object value = field.get(obj);
            Object value = field.get(adaptObj);

            Object adaptValue = mJavaAdaptersManager.adaptMarshal(value, new FieldAdapter(field));

            if (adaptValue != null) {   // TODO merge it checking with nillable
                if (field.isAnnotationPresent(XmlAttribute.class)) {
                    String attributeName = field.getAnnotation(XmlAttribute.class).name();
                    boolean primitiveTypeCompoused = processPrimitiveAttributes(field, obj, attributeName, sobj);
                    if (primitiveTypeCompoused == false) {
                        processAtributeValue(adaptValue, attributeName, sobj);
                    }
                } else if (field.isAnnotationPresent(XmlElement.class)) {
                    String valueName = field.getAnnotation(XmlElement.class).name();
                    //TODO implement default name usage
                    boolean primitiveTypeCompoused = processPrimitiveValue(field, obj, valueName, sobj);
                    if (primitiveTypeCompoused == false) {
                        boolean simpleTypeParsed = processSimpleValue(adaptValue, valueName, sobj);
                        if (simpleTypeParsed == false) {
                            boolean isWrapped = field.isAnnotationPresent(XmlElementWrapper.class);
                            String wrapperName = "";
                            if (isWrapped) {
                                wrapperName = (field.getAnnotation(XmlElementWrapper.class)).name();
                                if ("".equals(wrapperName)) {
                                    wrapperName = field.getName();
                                }
                            }
                            processComplexValue(adaptValue, wrapperName, isWrapped, valueName, sobj,pack, adaptObjClass);
                        }
                    }
                }
            }
        }
    }

    //TODO check for null for each object
    protected void processComplexValue(Object obj, String wrapperName, boolean isWrapped, String valueName, UMOObject sobj, Package pack, Class<?> ownerClass) throws InvocationTargetException, IllegalAccessException, InstantiationException, AdapterException {
//        Class objType = obj.getClass();
        Object adaptObj = mJavaAdaptersManager.adaptMarshal(obj, pack, ownerClass);
        Class<?> adaptObjClass = adaptObj.getClass();

        if (List.class.isInstance(adaptObj)) {
            List ourList = (List) adaptObj;
            Object listItem;
            UMO umoListItem;

            if (isWrapped) {
                UMOObject wrapper = mFactory.createProvider(UMOObject.class, wrapperName);
                sobj.put(wrapperName, wrapper);
                sobj = wrapper;
            }
            //TODO XXX this is hot fix for compatibility it MUST BE FIXED
            UMOArray list = mFactory.createProvider(UMOArray.class, valueName);
            sobj.putArray(valueName, list);
//            if (list.getWrappedObject() instanceof JSONArray) {
//                sobj.put(valueName, list);
//                for (int i = 0, d = ourList.size(); i < d; i++) {
//                    listItem = ourList.get(i);
//                    umoListItem = processObject(listItem, valueName);
//                    sobj.put(valueName, umoListItem);
//                }
//            } else {
            for (int i = 0, d = ourList.size(); i < d; i++) {
                listItem = ourList.get(i);
                umoListItem = processObject(listItem, valueName, ownerClass);
                list.put(valueName, umoListItem);
            }
//            }

        } else if (adaptObjClass.isArray()) {
            //TODO Need to implement
        } else {
            sobj.put(valueName, processObject(adaptObj, valueName, ownerClass));
        }

    }

}
