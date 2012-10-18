package biz.mobidev.android.jaxb.library.parser;

import java.io.InputStream;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 11:06 AM
 */
public interface Parser<T> {
    T parse(Class cls, InputStream data);

    //T parse(Class cls, String data);
}
