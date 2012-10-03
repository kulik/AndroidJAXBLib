package biz.mobidev.android.jaxb.library.composer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLProvider implements Provider {
    private static final String TAG = XMLProvider.class.getSimpleName();
    private Element mElement;
    private Document mDocument;

    public XMLProvider(Object obj) throws ParserConfigurationException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        mDocument = docBuilder.newDocument();
        mElement = mDocument.createElement(obj.getClass().getSimpleName());
        mDocument.appendChild(mElement);
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
