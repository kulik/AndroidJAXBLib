package ua.kharkov.borovyk.wiki_search.mynetwork;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/19/12
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElemXMLAdapterImpl implements IElementAdapter {
    private static final String TAG = ElemXMLAdapterImpl.class.getSimpleName();
    private Element mElement;

    public ElemXMLAdapterImpl(InputStream data){
        init(data);
    }

    @Override
    public void init(InputStream is) {
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
    public List getChildren() {
        List children = null;
        children = (List<Node>) mElement.getChildNodes();
        return children;
    }

    @Override
    public IElementAdapter getChild(String name) {
        return null;
    }

    @Override
    public String getValue(String tagName) {
        Node node;
        node = mElement.getElementsByTagName(tagName).item(0);
        if (node != null) {
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
