package ua.kharkov.borovyk.wiki_search.composer;

import ua.kharkov.borovyk.wiki_search.parser.AdapterTypes;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Composer<T> {
    public Object compose(Object data);
}
