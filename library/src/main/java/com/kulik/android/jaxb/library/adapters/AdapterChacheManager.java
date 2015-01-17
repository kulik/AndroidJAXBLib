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
package com.kulik.android.jaxb.library.adapters;

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import com.kulik.android.jaxb.library.loger.Log;

import java.util.HashMap;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class AdapterChacheManager {
    private static final String TAG = AdapterChacheManager.class.getSimpleName();

    private HashMap<Class<? extends XmlAdapter>, XmlAdapter> adaptersChache;

    public AdapterChacheManager() {
        adaptersChache = new HashMap<Class<? extends XmlAdapter>, XmlAdapter>();
    }

    /**
     * Returns adapter from chache or new instance? and chace it
     *
     * @param adapterClass - class of necessary
     * @return instance of necessary XmlAdapter class
     */
    public XmlAdapter getAdapter(Class<? extends XmlAdapter> adapterClass) {
        XmlAdapter adapter = null;
        if (adaptersChache.containsKey(adapterClass)) {
            adapter = adaptersChache.get(adapterClass);
        } else {
            try {
                adapter = adapterClass.newInstance();
                adaptersChache.put(adapterClass, adapter);
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Cant instantiate adapter " + adapterClass.getSimpleName() + " with exception:" + e);
            } catch (InstantiationException e) {
                Log.e(TAG, "Cant instantiate adapter " + adapterClass.getSimpleName() + " with exception:" + e);
            }

        }
        return adapter;
    }

}
