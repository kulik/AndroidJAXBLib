package biz.mobidev.android.jaxb.library.composer;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations;
import org.w3c.dom.Document;
import biz.mobidev.android.jaxb.library.parser.ElementAdapter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComposerImpl<T> implements Composer {
    private static final String TAG = ComposerImpl.class.getSimpleName();
    private ProviderTypes mProviderType;

    public ComposerImpl(ProviderTypes ad) {
        mProviderType = ad;
    }

    @Override
    public Provider compose(Object data) {
        Provider rootElem = null;
        try {
            rootElem = ProviderFactory.createProvider(mProviderType, data);
            processObject(data, rootElem);

        } catch (ParserConfigurationException e) {
            Log.e(TAG, "ParserConfigurationException while parcing: " + e.getMessage());
        }
        return rootElem;


    }

    protected void processObject(Object obj, Provider elem) {
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            String xmlValue = "";

            if (field.isAnnotationPresent(Annotations.Attribute.class)) {
                String annotationName = field.getAnnotation(Annotations.Attribute.class).name();
                xmlValue = elem.setAttributeValue(annotationName);
                processAtributeValue(xmlValue, field, obj);
            } else if (field.isAnnotationPresent(Annotations.Value.class)) {

                boolean simpleTypeParsed = processSimpleValue(elem, field, obj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                }

            }
        }
    }

    /**
     *
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected boolean processSimpleValue(ElementAdapter elem, Field field, Object obj) throws IllegalAccessException{
        String annotationName = field.getAnnotation(Annotations.Value.class).name();
        String value = elem.getValue(annotationName);

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


    /**
     * @param value String value from xml document
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected boolean processAtributeValue(String annotName, Field field, Object obj) throws IllegalAccessException {
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

    protected void processComplexValue(ElementAdapter elem, Field field, Object obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(Annotations.Value.class).name();

        if (valueType == List.class) {
            List<ElementAdapter> children = elem.getChildren(annotName);
            List objects = new ArrayList();
            field.set(obj, objects);

            Type genericType = field.getGenericType();
            for (int i = 0; i < children.size(); i++) {
                Object item = null;
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType paramType = (ParameterizedType) genericType;
                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                    item = tClass.newInstance();
                    objects.add(item);
                }
                processObject(item, children.get(i));
            }
        } else if (valueType.isArray()) {
            //TODO Need to implement
       }
        } else {
            ElementAdapter child = elem.getChild(annotName);
            Class<?> type = field.getType();
            Object childObj = type.newInstance();
            field.set(obj,childObj);
            processObject(childObj, child);
        }
    }


    private String convertToString(Document doc) {
        String xmlString = null;
        Transformer trans = null;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            Log.e(TAG, "TransformerConfigurationException while parcing: " + e.getMessage());
        }
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc);
        try {
            trans.transform(source, result);
        } catch (TransformerException e) {
            Log.e(TAG, "TransformerException while parcing: " + e.getMessage());
        }
        xmlString = sw.toString();
        Log.d(TAG, "Here's the xml: " + xmlString);

        return xmlString;
    }
}
