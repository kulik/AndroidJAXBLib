package biz.mobidev.android.jaxb.library.composer.providers.jsonProvider;

import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import org.json.JSONArray;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/15/12
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class JSONArrayProvider extends UMOArray {

    private JSONArray mJsonArray = new JSONArray();

    @Override
    public void put(Object value) {
        mJsonArray.put(value);
    }
}
