package biz.kulik.android.jaxb.library.parser.adapters;

import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.lang.reflect.Field;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 2:31 PM
 */
public class AdaptersManager {
    private AdapterChacheManager javaAdapterManager;
    private GlobalAdapterChacheManager packageAssignedAdaptersManager;

    public AdaptersManager() {
        javaAdapterManager = new AdapterChacheManager();
        packageAssignedAdaptersManager = new GlobalAdapterChacheManager();
    }

//    public Object marshal(Field field, Object value) {
//        XmlAdapter adapter = getAdapterForField(field);
//
//    }

    public XmlAdapter getAdapterForField(Field field) {
        XmlAdapter adapter;
        if (field.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
            XmlJavaTypeAdapter fieldLevelAnn = field.getAnnotation(XmlJavaTypeAdapter.class);
            adapter = javaAdapterManager.getAdapter(fieldLevelAnn.value());
        } else {
            Package pack = field.getDeclaringClass().getPackage();
            packageAssignedAdaptersManager.processPackage(pack);
            Class clazz = field.getClass();
            adapter = packageAssignedAdaptersManager.getAdapter(new Criteria(pack, clazz));
        }
        return adapter;
    }

}
