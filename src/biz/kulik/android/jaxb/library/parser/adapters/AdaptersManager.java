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
            Class clazz = methodFieldAdapter.getClassClass();
            Class returnType = methodFieldAdapter.getInputType(); //TODO make shure that composer with methods should use another method
            mPackageAssignedAdaptersManager.process(pack, clazz, returnType, methodFieldAdapter);
            adapter = mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
        }

        return adapter;
    }

    public XmlAdapter getAdapterByProp(Package pack, Class clazz, Class returnType) {

        return mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
    }

}
