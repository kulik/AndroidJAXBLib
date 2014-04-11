package com.kulik.android.jaxb.library.parser.providers;

import com.kulik.android.jaxb.library.Annotations.adapters.Constants;
import com.kulik.android.jaxb.library.loger.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static com.kulik.android.jaxb.library.Annotations.adapters.Constants.ANY_NS;

/**
 * User: Yevgen Kulik, nata
 * Date: 9/19/12
 * Time: 6:47 PM
 */
public class ElemXMLUnmarshalerImpl extends AbstractElementUnmarshaler {
    private static final String TAG = ElemXMLUnmarshalerImpl.class.getSimpleName();
    private Element mElement;

    public ElemXMLUnmarshalerImpl(Element elem) {
        mElement = elem;
    }

    public ElemXMLUnmarshalerImpl(InputStream data) {
        super(data);
    }

    public ElemXMLUnmarshalerImpl(String data) {
        super(data);
    }

    @Override
    protected void init(InputStream is) {
        Document doc;
        DocumentBuilderFactory dbf = getFactory();

        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(is);
            mElement = doc.getDocumentElement();
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "XML parse error ", e);
        } catch (SAXException e) {
            Log.e(TAG, "Wrong XML file ", e);
        } catch (IOException e) {
            Log.e(TAG, "I/O exception", e);
        }
    }

    private static DocumentBuilderFactory getFactory() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }

    @Override
    protected void init(String data) {
        Document doc;

        try {
            doc = loadXMLFromString(data);
            mElement = doc.getDocumentElement();
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "XML parse error ", e);
        } catch (SAXException e) {
            Log.e(TAG, "Wrong XML file ", e);
        } catch (IOException e) {
            Log.e(TAG, "I/O exception", e);
        } catch (Exception e) {
            Log.e(TAG, "unrecognized exception", e);
        }
    }

    public static Document loadXMLFromString(String xml) throws Exception {
        DocumentBuilderFactory factory = getFactory();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    @Override
    public List getChildren(String name, String ns) {
        List<ElementUnmarshaler> children = new ArrayList<ElementUnmarshaler>();
        NodeList nodes = mElement.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getLocalName().equals(name)
                    && isNSMatched(ns, node)) {
                children.add(new ElemXMLUnmarshalerImpl((Element) node));
            }
        }
        return children;
    }

    /**
     * mathed if ns in node equals to asked, also matched if asked one null or ""
     */
    private boolean isNSMatched(String ns, Node node) {
        return (ANY_NS.equals(ns) || ns.equals(node.getNamespaceURI()));
    }

    @Override
    public ElementUnmarshaler getChild(String name, String ns) {
        Element el = (Element) mElement.getElementsByTagNameNS(ns, name).item(0);
        return (el != null) ? new ElemXMLUnmarshalerImpl(el) : null;
    }

    @Override
    public boolean isChildExist(String name, String ns) {
        NodeList elementsByTagName = mElement.getElementsByTagNameNS(ns, name);
        boolean b = elementsByTagName.getLength() > 0 &&
                elementsByTagName.item(0) != null;
        return b;
    }

    @Override
    public String getValue(String tagName, String ns) {
        Node node;
        node = mElement.getElementsByTagNameNS(ns, tagName).item(0);
        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
            node = node.getChildNodes().item(0);
            if (node != null) {
                return node.getNodeValue();
            }
        }
        return null;
    }

    @Override
    public String getValue() {
        Node textNode = mElement.getFirstChild();
        if (textNode != null && textNode.getNodeType() == Node.TEXT_NODE) {
            return textNode.getNodeValue();
        }
        return null;
    }

    @Override
    public String getAttributeValue(String attrName, String ns) {
        if (Constants.ANY_NS.equals(ns)) {
            return mElement.getAttribute(attrName);
        } else {
            return mElement.getAttributeNS(ns, attrName);
        }
    }


}
