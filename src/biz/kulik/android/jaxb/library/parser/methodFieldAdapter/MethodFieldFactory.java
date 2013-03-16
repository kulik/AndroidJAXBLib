package biz.kulik.android.jaxb.library.parser.methodFieldAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * User: kulik
 * Date: 2/17/13
 * Time: 4:27 PM
 */
public class MethodFieldFactory {

    public static enum EntityType {
        FIELDS,
        METHODS
    }

    public static MethodFieldAdapter[] getAllEntytyByType(Class<?> clazz, EntityType entityType) {
        MethodFieldAdapter[] mfAdapters = null;

        switch (entityType) {
            case FIELDS:
                Field[] filds = clazz.getDeclaredFields();
                mfAdapters = new MethodFieldAdapter[filds.length];
                for (int i = 0, d = filds.length; i < d; i++) {
                    //TODO Pool optimization
                    mfAdapters[i] = new FieldAdapter(filds[i]);
                }
                break;
            case METHODS:
                Method[] methods = clazz.getDeclaredMethods();
                mfAdapters = new MethodFieldAdapter[methods.length];
                for (int i = 0, d = methods.length; i < d; i++) {
                    //TODO Pool optimization
                    mfAdapters[i] = new MethodAdapter(methods[i]);
                }
                break;
        }

        return mfAdapters;
    }
}
