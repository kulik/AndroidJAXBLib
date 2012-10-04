package biz.mobidev.android.jaxb.library.composer;

import org.json.JSONObject;
import org.w3c.dom.Element;

import java.util.List;

/**
 * User: kulik
 * Date: 9/21/12
 * Time: 3:40 PM
 */
public interface UniversalMarshalObject<T extends JSONObject, Node> {

    public void putChildren(List children);

    public void putChild(String key, String node);

    public String setValue(Object value);

    public String setAttributeValue(Element elem, String key, String value);
}
