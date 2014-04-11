package com.kulik.android.jaxb.library.parser.providers;

import java.util.List;

/**
 * User: nata
 * Date: 9/19/12
 * Time: 6:08 PM
 */
public interface ElementUnmarshaler {

    //public void init(InputStream is);

    public List getChildren(String name, String ns);

    //public List getChildren();

    public ElementUnmarshaler getChild(String name, String ns);

    public boolean isChildExist(String name, String ns);

    /**
     * if value doesnt exist return ""
     *
     * @param name
     * @return
     */
    public String getValue(String name, String ns);

    public String getValue();

    public String getAttributeValue(String name, String ns);


}
