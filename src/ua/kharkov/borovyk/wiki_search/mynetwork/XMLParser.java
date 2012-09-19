package ua.kharkov.borovyk.wiki_search.mynetwork;

import android.R;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/18/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class XMLParser<T> implements IParser<T> {
    private static final String TAG = XMLParser.class.getSimpleName();

    @Override
    public T parse(Class cls, InputStream data) {
        Document doc = toDocument(data);
        return parse(cls, doc);
    }

    @Override
    public T parse(Class cls, String data) {
        InputStream dat = new ByteArrayInputStream(data.getBytes());
        Document doc = toDocument(dat);
        T parsedObj = parse(cls, doc);
        return  parsedObj;
    }

    private Document toDocument(InputStream data) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(data);
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "XML parse error while converting to Document: " + e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e(TAG, "Wrong XML file structure while converting to Document: " + e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e(TAG, "I/O exception while converting to Document: " + e.getMessage());
            return null;
        }
        return doc;
    }


    private T parse(Class cls, Document document) {
        Element rootElement = document.getDocumentElement();
        T rootObj = null;
        try {
            rootObj = (T) cls.newInstance();
            processObject(rootObj, rootElement);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "InvocationTargetException while parcing: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, "IllegalAccessException while parcing: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, "InstantiationException while parcing: " + e.getMessage());
        }
        return rootObj;
    }


    protected void processObject(Object obj, Element elem) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<?> cl = obj.getClass();
        Field[] allFields = cl.getDeclaredFields();
        Log.d(TAG, "ProcessFields quantity:" + allFields.length);
        for (Field field : allFields) {
            Log.d(TAG, "ProcessFields field:" + field.getName() + "; AnnotationPresent:" + field.getAnnotations());
            String xmlValue = "";

            if (field.isAnnotationPresent(Annotations.XMLAttribute.class)) {
                String annotationName = field.getAnnotation(Annotations.XMLAttribute.class).name();
                xmlValue = elem.getAttribute(annotationName);   //Retrieves an attribute value by name.
                processAtributeValue(xmlValue, field, obj);
            } else if (field.isAnnotationPresent(Annotations.XMLValue.class)) {

                boolean simpleTypeParsed = processSimpleValue(elem, field, obj);
                if (simpleTypeParsed == false) {
                    processComplexValue(elem, field, obj);
                }

            }
        }

    }
    /**
     * @param value String value from xml document
     * @param field Field of object where to put value
     * @param obj   Object which field will be set
     * @throws IllegalAccessException
     */
    protected boolean processSimpleValue(Element elem, Field field, Object obj) throws IllegalAccessException {
        String annotationName = field.getAnnotation(Annotations.XMLValue.class).name();
        String value;

        field.setAccessible(true);
        Class<?> valueType = field.getType();
        if (String.class.equals(valueType)) {
            value = elem.getElementsByTagName(annotationName).item(0).getChildNodes().item(0).getNodeValue();
            field.set(obj, value);
            return true;
        } else if (Integer.class.equals(valueType)) {
            value = elem.getElementsByTagName(annotationName).item(0).getChildNodes().item(0).getNodeValue();
            field.set(obj, Integer.valueOf(value));
            return true;
        } else if (Long.class.equals(valueType)) {
            value = elem.getElementsByTagName(annotationName).item(0).getChildNodes().item(0).getNodeValue();
            field.set(obj, Long.valueOf(value));
            return true;
        } else if (Float.class.equals(valueType)) {
            value = elem.getElementsByTagName(annotationName).item(0).getChildNodes().item(0).getNodeValue();
            field.set(obj, Float.valueOf(value));
            return true;
        } else if (Double.class.equals(valueType)) {
            value = elem.getElementsByTagName(annotationName).item(0).getChildNodes().item(0).getNodeValue();
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
    protected boolean processAtributeValue(String value, Field field, Object obj) throws IllegalAccessException {
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

    protected void processComplexValue(Element elem, Field field, Object obj) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        field.setAccessible(true);
        Class<?> valueType = field.getType();
        String annotName = field.getAnnotation(Annotations.XMLValue.class).name();
        NodeList children = elem.getElementsByTagName(annotName);

        if (valueType == List.class) {
            NodeList childNodes = elem.getChildNodes();
            List objects = new ArrayList();
            field.set(obj, objects);

            Type genericType = field.getGenericType();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Object item = null;
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType paramType = (ParameterizedType) genericType;
                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
                    item = tClass.newInstance();
                    objects.add(item);
                }
                processObject(item, (Element) childNodes.item(i));
            }
        } else if (valueType.isArray()) {
            //TODO Need to implement
//            NodeList childNodes = elem.getChildNodes();
//            Type genericType = field.getGenericType();
//            ParameterizedType paramType = (ParameterizedType) genericType;
//            Class<?> aClass = (Class<T>) paramType.getActualTypeArguments()[0];
//
//            field.set(obj, Array.newInstance(aClass, childNodes.getLength()));
//
//            for (int i = 0; i < childNodes.getLength(); i++) {
//                Object item = null;
//             /*   if (genericType instanceof ParameterizedType) {
//                    ParameterizedType paramType = (ParameterizedType) genericType;
//                    Class<?> tClass = (Class<T>) paramType.getActualTypeArguments()[0];
//                    item = tClass.newInstance();
//                }*/
//                processObject(item, (Element) childNodes.item(i));
//            }
        } else {
            Class<?> type = field.getType();
            Object child = type.newInstance();
            field.set(obj,child);
            processObject(child, (Element) children.item(0));
        }
    }


}
