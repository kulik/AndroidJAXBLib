package biz.mobidev.android.jaxb.library.composer;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations;
import biz.mobidev.android.jaxb.library.parser.ElementAdapter;

import javax.xml.parsers.ParserConfigurationException;
import java.lang.reflect.*;
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
    public UniversalMarshalObject compose(Object data) {
        UniversalMarshalObject rootElem = null;
        try {
            rootElem = ProviderFactory.createProvider(mProviderType, data);
            processObject(data, rootElem);

        } catch (InvocationTargetException e) {
            Log.e(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        }
        return rootElem;
    }
    protected void processObject(Object obj, UniversalMarshalObject sobj) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        processFields(obj, sobj);
        //processMethods(obj, sobj);
    }

    //TODO implement this line of tree
    protected void processMethods(Object obj, UniversalMarshalObject sobj) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        Class<?> cl = obj.getClass();
        Method[] allMethods = cl.getDeclaredMethods();
        //	Log.v(TAG,"ProcessMethods quantity:" + allMethods.length);

        for (Method method : allMethods) {
            //	Log.v(TAG,"ProcessMethod field:" + method.getName()+ "; AnnotationPresent:" + method.isAnnotationPresent(ToSend.class));

            if (method.isAnnotationPresent(ToSend.class)) {
                method.setAccessible(true);
                String key = method.getAnnotation(ToSend.class).name();
                Object keyValue = method.invoke(obj);
                processValue(keyValue, key, sobj); //obj,
            }
        }
    }

    protected void processFields(Object obj, UniversalMarshalObject sobj) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
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

                boolean simpleTypeParsed = processSimpleValue(obj, field, sobj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                }

            }

            }
        }
    }

    protected boolean processSimpleValue(Object obj, Field field, UniversalMarshalObject sobj) throws IllegalAccessException{
        String annotationName = field.getAnnotation(Annotations.Value.class).name();
        String value;

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

}
