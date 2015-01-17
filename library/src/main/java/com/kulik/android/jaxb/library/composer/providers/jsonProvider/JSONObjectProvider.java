/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.composer.providers.jsonProvider;

import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import com.kulik.android.jaxb.library.composer.providers.abstractProvider.UMOObject;
import com.kulik.android.jaxb.library.loger.Log;

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
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putAttributeInt(String annotationName, Integer value) {
        try {
            mJSONObject.put(annotationName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putAttributeLong(String annotationName, Long value) {
        try {
            mJSONObject.put(annotationName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putAttributeFloat(String annotationName, Float value) {
        try {
            mJSONObject.put(annotationName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putAttributeDouble(String annotationName, Double value) {
        try {
            mJSONObject.put(annotationName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putAttributeBoolean(String annotationName, Boolean value) {
        try {
            mJSONObject.put(annotationName, value.booleanValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueStr(String valueName, String value) {
        try {
            mJSONObject.put(valueName, value);
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueInt(String valueName, Integer value) {
        try {
            mJSONObject.put(valueName, value.intValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueLong(String valueName, Long value) {
        try {
            mJSONObject.put(valueName, value.longValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueFloat(String valueName, Float value) {
        try {
            mJSONObject.put(valueName, value.floatValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueDouble(String valueName, Double value) {
        try {
            mJSONObject.put(valueName, value.doubleValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueBoolean(String valueName, Boolean value) {
        try {
            mJSONObject.put(valueName, value.booleanValue());
        } catch (JSONException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public void putValueStr(String value) {
        putValueStr("value", value);
    }

    @Override
    public void putValueInt(Integer value) {
        putValueInt("value", value);
    }

    @Override
    public void putValueLong(Long value) {
        putValueLong("value", value);
    }

    @Override
    public void putValueFloat(Float value) {
        putValueFloat("value", value);
    }

    @Override
    public void putValueDouble(Double value) {
        putValueDouble("value", value);
    }

    @Override
    public void putValueBoolean(Boolean value) {
        putValueBoolean("value", value);
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
