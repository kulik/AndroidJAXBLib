package com.kulik.android.jaxb.library.adapters;

import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapters;
import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class ParserAdapterChacheManager extends AbstractAdapterChacheManager{
    private static final String TAG = ParserAdapterChacheManager.class.getSimpleName();

    private HashMap<Criteria, XmlAdapter> adaptersChache;

//    private Set<Package> processedPackages;
    private Set<Class<?>> processedCasses;

    private Criteria mChacheCriteria;

    public ParserAdapterChacheManager() {
        adaptersChache = new HashMap<Criteria, XmlAdapter>();
//        processedPackages = new LinkedHashSet<Package>();
        processedCasses = new LinkedHashSet<Class<?>>();
        mChacheCriteria = new Criteria();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     */
    @Override
    public void process(Package pack, Class clazz, Class returnType) {

        try {
            XmlAdapter adapterInstance;
//            if (!processedPackages.contains(pack)) {
//                if (isAnnotationPresent(pack, XmlJavaTypeAdapters.class)) {
//                    XmlJavaTypeAdapters ann = getAnnotation(pack, XmlJavaTypeAdapters.class);
//                    XmlJavaTypeAdapter[] adapters = ann.value();
//                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
//                        adapterInstance = adapterMetaData.value().newInstance();
//                        adaptersChache.put(new Criteria(pack, null, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
//                    }
//                }
//                if (isAnnotationPresent(pack, XmlJavaTypeAdapter.class)) {
//                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) getAnnotation(pack, XmlJavaTypeAdapter.class);
//                    adapterInstance = adapterMetaData.value().newInstance();
//                    adaptersChache.put(new Criteria(pack, null, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
//                }
//                processedPackages.add(pack);
//            }
            if (!processedCasses.contains(clazz)) {
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
                    XmlJavaTypeAdapters ann = (XmlJavaTypeAdapters) clazz.getAnnotation(XmlJavaTypeAdapters.class);
                    XmlJavaTypeAdapter[] adapters = ann.value();
                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
                        adapterInstance = adapterMetaData.value().newInstance();
                        adaptersChache.put(new Criteria(pack, clazz, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
                    }
                }
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) clazz.getAnnotation(XmlJavaTypeAdapter.class);
                    adapterInstance = adapterMetaData.value().newInstance();
                    adaptersChache.put(new Criteria(pack, clazz, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
                }
                processedCasses.add(clazz);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public XmlAdapter getAdapter(Package pack, Class clazz, Class returnType) {
        XmlAdapter adapter = null;

        if (adaptersChache.containsKey(mChacheCriteria.set(pack, clazz, returnType, null))) {
            adapter = adaptersChache.get(mChacheCriteria);
//        } else if (adaptersChache.containsKey(mChacheCriteria.set(pack, null, returnType, null))) {
//            adapter = adaptersChache.get(mChacheCriteria);
        } else {
            adapter = DEFAULT_XML_ADAPTER;
        }
        return adapter;
    }
}

