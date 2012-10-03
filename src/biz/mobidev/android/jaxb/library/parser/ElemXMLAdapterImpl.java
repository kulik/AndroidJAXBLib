package biz.mobidev.android.jaxb.library.parser;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/19/12
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElemXMLAdapterImpl implements ElementAdapter {
    private static final String TAG = ElemXMLAdapterImpl.class.getSimpleName();
    private Element mElement;

    public ElemXMLAdapterImpl(Element elem) {
        mElement = elem;
    }


    public ElemXMLAdapterImpl(InputStream is) {
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
    public List getChildren(String name) {
        List<ElementAdapter> children = new ArrayList<ElementAdapter>();
        NodeList nodes = mElement.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++ ) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                children.add(new ElemXMLAdapterImpl((Element) node));
            }
        }
        return children;
    }

    @Override
    public ElementAdapter getChild(String name) {
        Element el = (Element) mElement.getElementsByTagName(name).item(0);
        return new ElemXMLAdapterImpl(el);
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
