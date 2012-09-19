package ua.kharkov.borovyk.wiki_search.mynetwork;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/18/12
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IParser<T> {
    T parse(Class cls, InputStream data);

    //T parse(Class cls, String data);
}
