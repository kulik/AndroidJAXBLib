package biz.kulik.android.jaxb.library.parser.adapters;

import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapters;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

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

    private static final XmlAdapter DEFAULT_XML_ADAPTER = new XmlAdapter() {
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

    public GlobalAdapterChacheManager() {
        adaptersChache = new HashMap<Criteria, XmlAdapter>();
        processedPackages = new LinkedHashSet<Package>();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     *
     * @param packaze
     */
    public void processPackage(Package packaze) {
        if (!processedPackages.contains(packaze)) {
            if (packaze.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
                XmlJavaTypeAdapters ann = packaze.getAnnotation(XmlJavaTypeAdapters.class);
                XmlJavaTypeAdapter[] adapters = ann.value();
                XmlAdapter adapterInstance;
                try {
                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
                        adapterInstance = adapterMetaData.value().newInstance();
                        adaptersChache.put(new Criteria(packaze, adapterMetaData.type()), adapterInstance);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                processedPackages.add(packaze);
            }
        }
    }

    /**
     * Returns {@link XmlAdapter} from chache. This set of adapters from package for class that
     *
     * @param criteria - class that representated object
     * @return instance of necessary XmlAdapter class
     */
    public XmlAdapter getAdapter(Criteria criteria) {

        XmlAdapter adapter = null;
        if (adaptersChache.containsKey(criteria)) {
            adapter = adaptersChache.get(criteria);
        } else {
            adapter = DEFAULT_XML_ADAPTER;
        }
        return adapter;
    }


}
