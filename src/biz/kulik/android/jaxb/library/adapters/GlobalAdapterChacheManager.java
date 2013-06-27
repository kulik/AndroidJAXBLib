package biz.kulik.android.jaxb.library.adapters;

import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapters;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class GlobalAdapterChacheManager {
    private static final String TAG = GlobalAdapterChacheManager.class.getSimpleName();

    private static final XmlAdapter<Object, Object> DEFAULT_XML_ADAPTER = new XmlAdapter<Object, Object>() {
        @Override
        public Object unmarshal(Object v) throws Exception {
            return v;
        }

        @Override
        public Object marshal(Object v) throws Exception {
            return v;
        }
    };

    private HashMap<Criteria, XmlAdapter> adaptersChache;

    private Set<Package> processedPackages;
    private Set<Class<?>> processedCasses;

    private Criteria mChacheCriteria;

    public GlobalAdapterChacheManager() {
        adaptersChache = new HashMap<Criteria, XmlAdapter>();
        processedPackages = new LinkedHashSet<Package>();
        processedCasses = new LinkedHashSet<Class<?>>();
        mChacheCriteria = new Criteria();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     */
    public void process(Package pack, Class clazz, Class returnType, MethodFieldAdapter methodFieldAdapter) {

        try {
            XmlAdapter adapterInstance;
            if (!processedPackages.contains(pack)) {
                if (pack.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
                    XmlJavaTypeAdapters ann = pack.getAnnotation(XmlJavaTypeAdapters.class);
                    XmlJavaTypeAdapter[] adapters = ann.value();
                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
                        adapterInstance = adapterMetaData.value().newInstance();
                        adaptersChache.put(new Criteria(pack, null, XmlAdapter.getUnmarshalerType(adapterInstance)), adapterInstance);
                    }
                }
                if (pack.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) pack.getAnnotation(XmlJavaTypeAdapter.class);
                    adapterInstance = adapterMetaData.value().newInstance();
                    adaptersChache.put(new Criteria(pack, null, XmlAdapter.getMarshalerType(adapterInstance)), adapterInstance);
                }
                processedPackages.add(pack);
            }
            if (!processedCasses.contains(clazz)) {
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
                    XmlJavaTypeAdapters ann = (XmlJavaTypeAdapters) clazz.getAnnotation(XmlJavaTypeAdapters.class);
                    XmlJavaTypeAdapter[] adapters = ann.value();
                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
                        adapterInstance = adapterMetaData.value().newInstance();
                        adaptersChache.put(new Criteria(pack, clazz, XmlAdapter.getMarshalerType(adapterInstance)), adapterInstance);
                    }
                }
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) clazz.getAnnotation(XmlJavaTypeAdapter.class);
                    adapterInstance = adapterMetaData.value().newInstance();
                    adaptersChache.put(new Criteria(pack, clazz, XmlAdapter.getMarshalerType(adapterInstance)), adapterInstance);
                }
                processedCasses.add(clazz);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public XmlAdapter getAdapter(Package pack, Class clazz, Class returnType) {
        XmlAdapter adapter = null;

        if (adaptersChache.containsKey(mChacheCriteria.set(pack, clazz, returnType))) {
            adapter = adaptersChache.get(mChacheCriteria);
        } else if (adaptersChache.containsKey(mChacheCriteria.set(pack, null, returnType))) {
            adapter = adaptersChache.get(mChacheCriteria);
        } else {
            adapter = DEFAULT_XML_ADAPTER;
        }
        return adapter;
    }
}
