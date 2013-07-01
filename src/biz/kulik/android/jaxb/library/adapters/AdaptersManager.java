package biz.kulik.android.jaxb.library.adapters;

import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.FieldAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 2:31 PM
 */
public class AdaptersManager {

    private AdapterChacheManager mJavaAdapterManager;
    private AbstractAdapterChacheManager mPackageAssignedAdaptersManager;

    public static enum ManagerType {
        PARSER, COMPOSER
    }

    public AdaptersManager(ManagerType type) {
        mJavaAdapterManager = new AdapterChacheManager();
        if (type == ManagerType.PARSER) {
            mPackageAssignedAdaptersManager = new ParserAdapterChacheManager();
        } else if (type == ManagerType.COMPOSER) {
            mPackageAssignedAdaptersManager = new ComposerAdapterChacheManager();
        }
    }

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
            mPackageAssignedAdaptersManager.process(pack, clazz, returnType);
            adapter = mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
        }

        return adapter;
    }

    public Object adaptMarshal(Object obj, FieldAdapter fieldAdapter) throws AdapterException {
        XmlAdapter adapter = getAdapterForField(fieldAdapter);
        Class<?> adapterValueType = XmlAdapter.getMarshalerType(adapter);
        if (!Object.class.equals(adapterValueType)) {
            return  XmlAdapter.marshal(adapter, obj);
        }
        return obj;
    }


    public XmlAdapter getAdapterByProp(Package pack, Class clazz, Class returnType) {
        mPackageAssignedAdaptersManager.process(pack, clazz, returnType);
        return mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
    }

    public Object adaptMarshal(Object obj, Package pack, Class<?> genericClass, Class<?> ownerClass) throws AdapterException {

        XmlAdapter adapter = getAdapterByProp(pack, ownerClass, genericClass);
        Class<?> adapterValueType = XmlAdapter.getMarshalerType(adapter);
        if (!Object.class.equals(adapterValueType)) {
            return  XmlAdapter.marshal(adapter, obj);
        }
        return obj;
    }

}
