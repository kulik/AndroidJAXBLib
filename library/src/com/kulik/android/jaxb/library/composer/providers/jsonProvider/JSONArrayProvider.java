package com.kulik.android.jaxb.library.composer.providers.jsonProvider;

import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOArray;
import org.json.JSONArray;

/**
 * User: kulik
 * Date: 10/15/12
 * Time: 8:36 PM
 */
public class JSONArrayProvider implements UMOArray {

    private JSONArray mJsonArray = new JSONArray();

    @Override
    public Object getWrappedObject() {
        return mJsonArray;
    }

    @Override
    public void setWrappedObject(Object obj) {
        mJsonArray = (JSONArray) obj;
    }

    @Override
    public Object getRootDocument() {
        return mJsonArray;
    }

    @Override
    public void put(String key, UMO value) {
        mJsonArray.put(value.getWrappedObject());
    }
}
