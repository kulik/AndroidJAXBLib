package biz.kulik.android.jaxb.library.parser;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/25/12
 * Time: 11:39 AM
 */
public abstract class AbstractElementAdapter implements ElementAdapter {


    protected AbstractElementAdapter(InputStream data) {
        init(data);
    }

    protected AbstractElementAdapter(String data){
        init(data);
    }

    public AbstractElementAdapter() {
    }

    protected abstract void init(InputStream data);

    protected abstract void init(String data);

}
