package biz.kulik.android.jaxb.library.parser.providers;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/25/12
 * Time: 11:39 AM
 */
public abstract class AbstractElementUnmarshaler implements ElementUnmarshaler {


    protected AbstractElementUnmarshaler(InputStream data) {
        init(data);
    }

    protected AbstractElementUnmarshaler(String data){
        init(data);
    }

    public AbstractElementUnmarshaler() {
    }

    protected abstract void init(InputStream data);

    protected abstract void init(String data);

}
