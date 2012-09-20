package ua.kharkov.borovyk.wiki_search.mynetwork;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/20/12
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElemJSONAdapterImpl implements ElementAdapter {
    private static final String TAG = ElemJSONAdapterImpl.class.getSimpleName();
    private JSONObject mObject;

    public ElemJSONAdapterImpl(JSONObject obj) {
        mObject = obj;
    }

    public static String openFileAsString(InputStream stream) {
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader buff = new BufferedReader(isr);
        StringBuffer strBuff = new StringBuffer();
        String s;
        try {
            while ((s = buff.readLine()) != null) {
                strBuff.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuff.toString();
    }

    public ElemJSONAdapterImpl(InputStream data) {
        String str = openFileAsString(data);
        JSONObject json = null;
        try {
            json = new JSONObject(str);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException when retriving json object from string");
        }
        mObject = json;
    }

    @Override
    public List getChildren(String name) {
        List<ElementAdapter> children = new ArrayList<ElementAdapter>();
        JSONObject ob = null;
        JSONArray jarray = null;
        try {
            jarray = mObject.getJSONArray(name);
            for (int i = 0; i < jarray.length(); i++) {
                ob = (JSONObject) jarray.get(i);
                children.add(new ElemJSONAdapterImpl(ob));
            }
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return children;
    }

    @Override
    public ElementAdapter getChild(String name) {
        JSONObject jobj = new JSONObject();
        try {
            jobj = mObject.getJSONObject(name);
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return new ElemJSONAdapterImpl(jobj);
    }

    @Override
    public String getValue(String name) {
        try {
            return mObject.getString(name);
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return "";
    }

    @Override
    public String getAttributeValue(String name) {
        return getValue(name);
    }

}
