package com.kulik.android.jaxb.library.adapters;

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public abstract class AbstractAdapterChacheManager {
    private static final String TAG = AbstractAdapterChacheManager.class.getSimpleName();

    protected static final XmlAdapter<Object, Object> DEFAULT_XML_ADAPTER = new XmlAdapter<Object, Object>() {
        @Override
        public Object unmarshal(Object v) throws Exception {
            return v;
        }

        @Override
        public Object marshal(Object v) throws Exception {
            return v;
        }
    };

    protected HashMap<Criteria, XmlAdapter> mAdaptersChache;

    private Set<Package> mProcessedPackages;
    private Set<Class<?>> mProcessedCasses;

    private Criteria mChacheCriteria;

    public AbstractAdapterChacheManager() {
        mAdaptersChache = new HashMap<Criteria, XmlAdapter>();
        mProcessedPackages = new LinkedHashSet<Package>();
        mProcessedCasses = new LinkedHashSet<Class<?>>();
        mChacheCriteria = new Criteria();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     */
    public abstract void process(Package pack, Class clazz, Class returnType);

    public abstract XmlAdapter getAdapter(Package pack, Class clazz, Class returnType);
}
