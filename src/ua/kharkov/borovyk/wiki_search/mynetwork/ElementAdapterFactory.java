package ua.kharkov.borovyk.wiki_search.mynetwork;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/19/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElementAdapterFactory {

    public static IElementAdapter createAdapter(AdapterTypes ad, InputStream data) {
        IElementAdapter adapter = null;
        switch (ad) {
            case XMLAdapter:
                adapter = new ElemXMLAdapterImpl(null);
                adapter.init(data);
                break;
            case JSONAdapter:
                break;
            case SOAPAdapter:
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry =)");
            }

        }
        return adapter;
    }
}
