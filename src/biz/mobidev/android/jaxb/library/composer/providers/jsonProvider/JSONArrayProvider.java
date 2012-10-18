package biz.mobidev.android.jaxb.library.composer.providers.jsonProvider;

import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import org.json.JSONArray;

/**
 * User: kulik
 * Date: 10/15/12
 * Time: 8:36 PM
 */
public class JSONArrayProvider extends UMOArray {

    private JSONArray mJsonArray = new JSONArray();

    @Override
    public void put(UMO value) {
        mJsonArray.put(value.getWrappedObject());
    }

    @Override
    public Object getWrappedObject() {
        return mJsonArray;
    }
}
