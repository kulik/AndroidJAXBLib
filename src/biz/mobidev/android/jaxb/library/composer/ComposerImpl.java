package biz.mobidev.android.jaxb.library.composer;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations;
import biz.mobidev.android.jaxb.library.composer.providers.ObjectType;
import biz.mobidev.android.jaxb.library.composer.providers.ProviderFactory;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.mobidev.android.jaxb.library.composer.providers.ProviderTypes;

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
    private ProviderTypes mProviderType;

    public ComposerImpl(ProviderTypes ad) {
        mProviderType = ad;
    }

    @Override
    public UMO compose(Object data) {
        UMO rootElem = null;
            rootElem = processObject(data);
        return rootElem;
    }

    protected UMO processObject(Object obj) {
        UMO myElem = null;
        Class objType = obj.getClass();
        try {
            if (objType == List.class) {
                List ourList = (List) obj;
                myElem = ProviderFactory.createProvider(mProviderType, ObjectType.ARRAY); //new UMOArray();


                for (Object itemObj : ourList) {
                    ((UMOArray) myElem).put(processObject(itemObj));
                }
            } else if (objType.isArray()) {
                //TODO Need to implement
            } else {
                myElem = ProviderFactory.createProvider(mProviderType, ObjectType.OBJECT); //new UMOObject();
                processObjectContent(obj, (UMOObject) myElem);
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
            sobj.putAnnotation(annotationName, (String) value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.putAnnotation(annotationName, (Integer) value);
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.putAnnotation(annotationName, (Long) value);
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.putAnnotation(annotationName, (Float) value);
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.putAnnotation(annotationName, (Double) value);
            return true;
        }
        return false;
    }

    protected boolean processSimpleValue(Object value, String valueName, UMOObject sobj) {

        Class<?> valueType = value.getClass();
        if (String.class.equals(valueType)) {
            sobj.putValue(valueName, (String) value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            sobj.putValue(valueName, (Integer) value);
            return true;
        } else if (Long.class.equals(valueType)) {
            sobj.putValue(valueName, (Long) value);
            return true;
        } else if (Float.class.equals(valueType)) {
            sobj.putValue(valueName, (Float) value);
            return true;
        } else if (Double.class.equals(valueType)) {
            sobj.putValue(valueName, (Double) value);
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
            Object value = field.get(obj);
            if (field.isAnnotationPresent(Annotations.Attribute.class)) {
                String annotationName = field.getAnnotation(Annotations.Attribute.class).name();
                processAtributeValue(value, annotationName, sobj);
            } else if (field.isAnnotationPresent(Annotations.Value.class)) {
                String valueName = field.getAnnotation(Annotations.Attribute.class).name();
                boolean simpleTypeParsed = processSimpleValue(value, valueName, sobj);
                if (simpleTypeParsed == false) {
                    processComplexValue(value, valueName, sobj);
                }
            }
        }
    }

    //TODO check for null for each object
    protected void processComplexValue(Object obj, String valueName, UMOObject sobj) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Class objType = obj.getClass();

        if (objType == List.class) {
            List ourList = (List) obj;

//            for (Object itemObj : ourList) {
//                sobj.put(processObject(itemObj));
//            }
        } else if (objType.isArray()) {
            //TODO Need to implement
        } else {
            sobj.put(valueName, processObject(obj));
        }

    }

}
