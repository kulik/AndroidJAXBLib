package ua.kharkov.borovyk.wiki_search.composer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Provider {

    public void putChildren(List children);

    public void putChild(String key, String node);

    public String setValue(Object value);

    public String setAttributeValue(Object attr);

}
