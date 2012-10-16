
package biz.mobidev.android.jaxb.library.composer.providers.jsonProvider;

import android.util.Log;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/15/12
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class JSONObjectProvider extends UMOObject {
    private static final String TAG = JSONObjectProvider.class.getSimpleName();

    private JSONObject mJSONObject = new JSONObject();

    @Override
    public void put(String key, UMO umo) {
        try {
            mJSONObject.put(key, umo);
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAnnotation(String annotationName, String value) {
        try {
            mJSONObject.put(annotationName, value);
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAnnotation(String annotationName, Integer value) {
        try {
            mJSONObject.put(annotationName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAnnotation(String annotationName, Long value) {
        try {
            mJSONObject.put(annotationName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAnnotation(String annotationName, Float value) {
        try {
            mJSONObject.put(annotationName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putAnnotation(String annotationName, Double value) {
        try {
            mJSONObject.put(annotationName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValue(String valueName, String value) {
        try {
            mJSONObject.put(valueName, value);
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValue(String valueName, Integer value) {
        try {
            mJSONObject.put(valueName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValue(String valueName, Long value) {
        try {
            mJSONObject.put(valueName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValue(String valueName, Float value) {
        try {
            mJSONObject.put(valueName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }

    @Override
    public void putValue(String valueName, Double value) {
        try {
            mJSONObject.put(valueName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG,e.toString());
        }
    }
}
