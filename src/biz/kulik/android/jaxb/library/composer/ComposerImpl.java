package biz.kulik.android.jaxb.library.composer;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import biz.kulik.android.jaxb.library.Annotations.XmlRootElement;
import biz.kulik.android.jaxb.library.adapters.AdapterException;
import biz.kulik.android.jaxb.library.adapters.AdaptersManager;
import biz.kulik.android.jaxb.library.composer.providers.ProviderFactory;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.FieldAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
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
        Class<?> objClass = obj.getClass();
        try {
            if (obj != null) {
                String root = "";
                if (objClass.isAnnotationPresent(XmlRootElement.class)) {
                    root = ((XmlRootElement) objClass.getAnnotation(XmlRootElement.class)).name();
                }
                //TODO need changed to Collection.class
                if (objClass.isAssignableFrom(List.class)) {
                    List ourList = (List) obj;

                    myElem = mFactory.createProvider(UMOArray.class, root);
                    //TODO Wrapper
                    for (int i = 0, d = ourList.size(); i < d; i++) {
                        Object itemObj = ourList.get(i);
//                        Object adaptObj = mJavaAdaptersManager.adaptMarshal(obj, objClass.getPackage(), objClass, ownerClass); TODO add adapt
                        UMO item = processObject(itemObj, "".equals(valueName) ? root : valueName, ownerClass);
                        //TODO check if simple type
                        ((UMOArray) myElem).put("", item);
                    }
                } else if (objClass.isArray()) {
                    //TODO Need to implement
                } else {
                    myElem = mFactory.createProvider(UMOObject.class, "".equals(valueName) ? root : valueName);

                    Object adaptObj = mJavaAdaptersManager.adaptMarshal(obj, objClass.getPackage(), objClass, ownerClass);
                    Class<?> adaptClass = adaptObj.getClass();

                    processObjectContent(adaptObj, (UMOObject) myElem, adaptClass.getPackage());
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

    private void processObjectContent(Object obj, UMOObject sobj, Package pack) throws IllegalAccessException, InvocationTargetException, InstantiationException, AdapterException {
        processFields(obj, sobj, pack);
        //processMethods();
    }

    protected void processFields(Object obj, UMOObject sobj, Package pack) throws IllegalAccessException, InvocationTargetException, InstantiationException, AdapterException {
        Class<?> objClass = obj.getClass();
        Field[] allFields = objClass.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            field.setAccessible(true);

//            Object value = field.get(obj);
            Object value = field.get(obj);

            if (value != null) {   // TODO merge it checking with nillable
                Object adaptValue = mJavaAdaptersManager.adaptMarshal(value, new FieldAdapter(field));
                Class<?> adaptClass = adaptValue.getClass();

                if (adaptValue != null) {
                    if (field.isAnnotationPresent(XmlAttribute.class)) {
                        String attributeName = field.getAnnotation(XmlAttribute.class).name();
                        boolean primitiveTypeCompoused = SimpleValueUtils.processPrimitiveAttributes(adaptValue, adaptClass, attributeName, sobj);
                        if (primitiveTypeCompoused == false) {
                            SimpleValueUtils.processAtributeValue(adaptValue, adaptClass, attributeName, sobj);
                        }
                    } else if (field.isAnnotationPresent(XmlElement.class)) {
                        String valueName = field.getAnnotation(XmlElement.class).name();
                        //TODO implement default name usage
                        boolean primitiveTypeCompoused = SimpleValueUtils.processPrimitiveValue(adaptValue, adaptClass, valueName, sobj);
                        if (!primitiveTypeCompoused) {
                            boolean simpleTypeParsed = SimpleValueUtils.processSimpleValue(adaptValue, adaptClass, valueName, sobj);
                            if (!simpleTypeParsed) {
                                boolean isWrapped = field.isAnnotationPresent(XmlElementWrapper.class);
                                String wrapperName = "";
                                if (isWrapped) {
                                    wrapperName = (field.getAnnotation(XmlElementWrapper.class)).name();
                                    if ("".equals(wrapperName)) {
                                        wrapperName = field.getName();
                                    }
                                }
                                processComplexValue(adaptValue, wrapperName, isWrapped, valueName, sobj, pack, objClass, field);
                            }
                        }
                    }
                }
            }
        }
    }

    //TODO check for null for each object

    protected void processComplexValue(Object obj, String wrapperName, boolean isWrapped, String valueName, UMOObject sobj, Package pack, Class<?> ownerClass, Field field) throws InvocationTargetException, IllegalAccessException, InstantiationException, AdapterException {
        Class objClass = obj.getClass();

        if (List.class.isInstance(obj)) {
            List ourList = (List) obj;
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
            Class<?> genericClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
            for (int i = 0, d = ourList.size(); i < d; i++) {
                listItem = ourList.get(i);

                Object adaptItemValue = mJavaAdaptersManager.adaptMarshal(listItem, pack, genericClass, ownerClass);
                Class<?> adaptItemClass = adaptItemValue.getClass();

                umoListItem = processObject(adaptItemValue, valueName, ownerClass);
                list.put(valueName, umoListItem);
            }
//            }

        } else if (objClass.isArray()) {
            //TODO Need to implement
        } else {
            Object adaptValue = mJavaAdaptersManager.adaptMarshal(obj, pack, objClass, ownerClass);

            sobj.put(valueName, processObject(adaptValue, valueName, ownerClass));
        }

    }

}
