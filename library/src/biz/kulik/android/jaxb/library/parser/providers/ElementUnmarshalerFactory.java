package biz.kulik.android.jaxb.library.parser.providers;

import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 27/11/12
 * Time: 70:52 AM
 */
public class ElementUnmarshalerFactory {

    public static ElementUnmarshaler createAdapter(UnMarshalerTypes ad, InputStream data) {
        ElementUnmarshaler unmarshaler = null;
        switch (ad) {
            case XMLAdapter:
                unmarshaler = new ElemXMLUnmarshalerImpl(data);
                break;
            case JSONAdapter:
                unmarshaler = new ElemJSONUnmarshalerImpl(data);
                break;
            case SOAPAdapter:
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry");
            }

        }
        return unmarshaler;
    }

    public static ElementUnmarshaler createAdapter(UnMarshalerTypes ad, String data) {
        ElementUnmarshaler unmarshaler = null;
        switch (ad) {
            case XMLAdapter:
                unmarshaler = new ElemXMLUnmarshalerImpl(data);
                break;
            case JSONAdapter:
                unmarshaler = new ElemJSONUnmarshalerImpl(data);
                break;
            case SOAPAdapter:
                //unmarshaler = new Ksoapaa();
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry");
            }

        }
        return unmarshaler;
    }
}
