package biz.kulik.android.jaxb.library.composer;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import biz.kulik.android.jaxb.library.Annotations.XmlRootElement;
import biz.kulik.android.jaxb.library.composer.providers.ProviderFactory;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;

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

    public ComposerImpl(ProviderTypes ad) {
        mFactory = new ProviderFactory(ad);
    }

    @Override
    public UMO compose(Object data) {
        UMO rootElem = null;
        rootElem = processObject(data, "");
        return rootElem;
    }

    protected UMO processObject(Object obj, String valueName) {
        UMO myElem = null;
        Class objType = obj.getClass();
        try {
            if (obj != null) {
                //TODO need changed to Collection.class
                String root = "";
                if (objType.isAnnotationPresent(XmlRootElement.class)) {
                    root = ((XmlRootElement) objType.getAnnotation(XmlRootElement.class)).name();
                }
                if (objType.isAssignableFrom(List.class)) {
                    List ourList = (List) obj;

                    myElem = mFactory.createProvider(UMOArray.class, root);
                    //TODO Wrapper
                    for (int i = 0, d = ourList.size(); i < d; i++) {

                        //TODO check if simple type
                        ((UMOArray) myElem).put(processObject(ourList.get(i), "".equals(valueName) ? root : valueName));
                    }
                } else if (objType.isArray()) {
                    //TODO Need to implement
                } else {
                    myElem = mFactory.createProvider(UMOObject.class, "".equals(valueName) ? root : valueName);
                    processObjectContent(obj, (UMOObject) myElem);
                }
            }
        } catch (InvocationTargetException e) {
            Log.e(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, e.getMessage());
        }
        return myElem;

    }

    private void processObjectContent(Object obj, UMOObject sobj) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        processFields(obj, sobj);
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

    protected void processFields(Object obj, UMOObject sobj) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            field.setAccessible(true);

            Object value = field.get(obj);
            if (value != null) {   // TODO merge it checking with nillable
                if (field.isAnnotationPresent(XmlAttribute.class)) {
                    String attributeName = field.getAnnotation(XmlAttribute.class).name();
                    boolean primitiveTypeCompoused = processPrimitiveAttributes(field, obj, attributeName, sobj);
                    if (primitiveTypeCompoused == false) {
                        processAtributeValue(value, attributeName, sobj);
                    }
                } else if (field.isAnnotationPresent(XmlElement.class)) {
                    String valueName = field.getAnnotation(XmlElement.class).name();
                    //TODO implement default name usage
                    boolean primitiveTypeCompoused = processPrimitiveValue(field, obj, valueName, sobj);
                    if (primitiveTypeCompoused == false) {
                        boolean simpleTypeParsed = processSimpleValue(value, valueName, sobj);
                        if (simpleTypeParsed == false) {
                            boolean isWrapped = field.isAnnotationPresent(XmlElementWrapper.class);
                            String wrapperName = "";
                            if (isWrapped) {
                                wrapperName = (field.getAnnotation(XmlElementWrapper.class)).name();
                                if ("".equals(wrapperName)) {
                                    wrapperName = field.getName();
                                }
                            }
                            processComplexValue(value, wrapperName, isWrapped, valueName, sobj);
                        }
                    }
                }
            }
        }
    }

    //TODO check for null for each object
    protected void processComplexValue(Object obj, String wrapperName, boolean isWrapped, String valueName, UMOObject sobj) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Class objType = obj.getClass();

        if (List.class.isInstance(obj)) {
            //TODO Check for Wrapper

            if (isWrapped) {
               UMOObject wrapper = mFactory.createProvider(UMOObject.class, wrapperName);
                sobj.put(wrapperName, wrapper);
                sobj = wrapper;
            }
            UMOArray list = mFactory.createProvider(UMOArray.class, valueName);
            List ourList = (List) obj;
            Object listItem;
            UMO umoListItem;
            if (isWrapped) {
                for (int i = 0, d = ourList.size(); i < d; i++) {
                    listItem = ourList.get(i);
                    umoListItem = processObject(listItem, valueName);
                    list.put(umoListItem);
                }
                sobj.put(valueName, list);
            } else {
                for (int i = 0, d = ourList.size(); i < d; i++) {
                    listItem = ourList.get(i);
                    umoListItem = processObject(listItem, valueName);
                    sobj.put(valueName, umoListItem);
                }
            }

        } else if (objType.isArray()) {
            //TODO Need to implement
        } else {
            sobj.put(valueName, processObject(obj, valueName));
        }

    }

}
