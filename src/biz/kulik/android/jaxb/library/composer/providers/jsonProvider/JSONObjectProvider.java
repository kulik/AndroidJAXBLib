
package biz.kulik.android.jaxb.library.composer.providers.jsonProvider;

import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import biz.kulik.android.jaxb.library.loger.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * User: kulik
 * Date: 10/15/12
 * Time: 8:37 PM
 */
public class JSONObjectProvider implements UMOObject {
    private static final String TAG = JSONObjectProvider.class.getSimpleName();

    private JSONObject mJSONObject = new JSONObject();

    @Override
    public void put(String key, UMO umo) {
        try {
            mJSONObject.put(key, umo.getWrappedObject());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putArray(String valueName, UMO value) {
       put(valueName, value);
    }

    @Override
    public void putAttributeStr(String annotationName, String value) {
        try {
            mJSONObject.put(annotationName, value);
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAttributeInt(String annotationName, Integer value) {
        try {
            mJSONObject.put(annotationName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAttributeLong(String annotationName, Long value) {
        try {
            mJSONObject.put(annotationName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAttributeFloat(String annotationName, Float value) {
        try {
            mJSONObject.put(annotationName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAttributeDouble(String annotationName, Double value) {
        try {
            mJSONObject.put(annotationName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAttributeBoolean(String annotationName, Boolean value) {
        try {
            mJSONObject.put(annotationName, value.booleanValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueStr(String valueName, String value) {
        try {
            mJSONObject.put(valueName, value);
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueInt(String valueName, Integer value) {
        try {
            mJSONObject.put(valueName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueLong(String valueName, Long value) {
        try {
            mJSONObject.put(valueName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueFloat(String valueName, Float value) {
        try {
            mJSONObject.put(valueName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueDouble(String valueName, Double value) {
        try {
            mJSONObject.put(valueName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValueBoolean(String valueName, Boolean value) {
        try {
            mJSONObject.put(valueName, value.booleanValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public Object getWrappedObject() {
        return mJSONObject;
    }

    @Override
    public void setWrappedObject(Object obj) {
        mJSONObject = (JSONObject) obj;
    }

    @Override
    public Object getRootDocument() {
        return mJSONObject;
    }
}
