package ua.kharkov.borovyk.wiki_search.mynetwork;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/19/12
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractElement {

    public List getChildren();
    public String getValue();
    public String getAttributeValue(String tagAttribute);

}
