package biz.mobidev.android.jaxb.library.parser;

import java.io.InputStream;

/**
 * User: nata
 * Date: 9/19/12
 * Time: 7:45 PM
 */
public class ElementAdapterFactory {

    public static ElementAdapter createAdapter(AdapterTypes ad, InputStream data) {
        ElementAdapter adapter = null;
        switch (ad) {
            case XMLAdapter:
                adapter = new ElemXMLAdapterImpl(data);
                break;
            case JSONAdapter:
                adapter = new ElemJSONAdapterImpl(data);
                break;
            case SOAPAdapter:
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry");
            }

        }
        return adapter;
    }
}
