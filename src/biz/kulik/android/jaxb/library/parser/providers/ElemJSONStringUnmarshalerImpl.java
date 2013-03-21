package biz.kulik.android.jaxb.library.parser.providers;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nata
 * Date: 9/20/12
 * Time: 12:39 PM
 */
public class ElemJSONStringUnmarshalerImpl implements ElementUnmarshaler {
    private static final String TAG = ElemJSONStringUnmarshalerImpl.class.getSimpleName();

    private static final String stub_wrapper = "SELF";
    private String mWrappedString;

    public ElemJSONStringUnmarshalerImpl(String obj) {
        super();
        mWrappedString = obj;
    }

    @Override
    public List getChildren(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ElementUnmarshaler getChild(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return mWrappedString;
    }

    @Override
    public String getAttributeValue(String name) {
        return getValue(name);
    }

}
