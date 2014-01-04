package biz.kulik.android.jaxb.library.adapters;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

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
