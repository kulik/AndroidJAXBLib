package biz.kulik.android.jaxb.library.parser.providers;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nata
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
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(is);
            mElement = doc.getDocumentElement();
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "XML parse error " + e.getMessage());
        } catch (SAXException e) {
            Log.e(TAG, "Wrong XML file " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "I/O exception" + e.getMessage());
        }
    }

    @Override
    protected void init(String data) {
        Document doc;

        try {
            doc = loadXMLFromString(data);
            mElement = doc.getDocumentElement();
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "XML parse error " + e.getMessage());
        } catch (SAXException e) {
            Log.e(TAG, "Wrong XML file " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "I/O exception" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    @Override
    public List getChildren(String name) {
        List<ElementUnmarshaler> children = new ArrayList<ElementUnmarshaler>();
        NodeList nodes = mElement.getElementsByTagName(name);
        for (int i = 0; i < nodes.getLength(); i++ ) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                children.add(new ElemXMLUnmarshalerImpl((Element) node));
            }
        }
        return children;
    }

    @Override
    public ElementUnmarshaler getChild(String name) {
        Element el = (Element) mElement.getElementsByTagName(name).item(0);
        return new ElemXMLUnmarshalerImpl(el);
    }

    @Override
    public String getValue(String tagName) {
        Node node;
        node = mElement.getElementsByTagName(tagName).item(0);
        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
            node = node.getChildNodes().item(0);
            if (node != null) {
                return node.getNodeValue();
            }
        }
        return null;
    }

    @Override
    public String getAttributeValue(String attrName) {
        return mElement.getAttribute(attrName);
    }


}
