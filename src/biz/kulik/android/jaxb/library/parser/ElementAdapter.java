package biz.kulik.android.jaxb.library.parser;

import java.util.List;

/**
 * User: nata
 * Date: 9/19/12
 * Time: 6:08 PM
 */
public interface ElementAdapter {

    //public void init(InputStream is);

    public List getChildren(String name);

    //public List getChildren();

    public ElementAdapter getChild(String name);

    /**
     * if value doesnt exist return ""
     * @param name
     * @return
     */
    public String getValue(String name);

    public String getAttributeValue(String name);


}
