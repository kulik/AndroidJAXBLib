package biz.kulik.android.jaxb.library.composer.providers.jsonProvider;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import org.json.JSONArray;

/**
 * User: kulik
 * Date: 10/15/12
 * Time: 8:36 PM
 */
public class JSONArrayProvider implements UMOArray {

    private JSONArray mJsonArray = new JSONArray();

    @Override
    public void put(UMO value) {
        mJsonArray.put(value.getWrappedObject());
    }

    @Override
    public Object getWrappedObject() {
        return mJsonArray;
    }

    @Override
    public Object getRootDocument() {
        return mJsonArray;
    }
}
