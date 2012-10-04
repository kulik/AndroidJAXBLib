package biz.mobidev.android.jaxb.library.composer;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * User: kulik
 * Date: 9/21/12
 * Time: 4:18 PM
 */
public class XMLUnivObject implements UniversalMarshalObject {
    private static final String TAG = XMLUnivObject.class.getSimpleName();
    private Element mElement;
    private Document mDocument;

    public XMLUnivObject(Object obj) {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            mDocument = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void putChildren(List children) {

    }

    @Override
    public void putChild(String key, String value) {
        Element child = mDocument.createElement(key);
        child.appendChild(mDocument.createTextNode(value));
        mElement.appendChild(child);

    }

    @Override
    public String setValue(Object value) {
        return null;
    }


    @Override
    public String setAttributeValue(Element elem, String key, String value) {
        elem.setAttribute(key, value);
        //staff.setAttribute("id", "1");
        return null;
    }
}
