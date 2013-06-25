package biz.kulik.android.jaxb.library.parser.adapters;

import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 2:31 PM
 */
public class AdaptersManager {
    private AdapterChacheManager mJavaAdapterManager;
    private GlobalAdapterChacheManager mPackageAssignedAdaptersManager;

    public AdaptersManager() {
        mJavaAdapterManager = new AdapterChacheManager();
        mPackageAssignedAdaptersManager = new GlobalAdapterChacheManager();
    }

//    public Object marshal(Field field, Object value) {
//        XmlAdapter adapter = getAdapterForField(field);
//
//    }

    public XmlAdapter getAdapterForField(MethodFieldAdapter methodFieldAdapter) {
        XmlAdapter adapter;
        if (methodFieldAdapter.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
            XmlJavaTypeAdapter fieldLevelAnn = methodFieldAdapter.getAnnotation(XmlJavaTypeAdapter.class);
            adapter = mJavaAdapterManager.getAdapter(fieldLevelAnn.value());
            //TODO add debug mode Check class types compatibility
        } else {
            Package pack = methodFieldAdapter.getPackage();
            mPackageAssignedAdaptersManager.processPackage(pack);
            Class clazz = methodFieldAdapter.getClass();
            adapter = mPackageAssignedAdaptersManager.getAdapter(new Criteria(pack, clazz));
        }

        return adapter;
    }



}
