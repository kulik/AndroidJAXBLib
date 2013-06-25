package biz.kulik.android.jaxb.library.parser.methodFieldAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 5:10 PM
 */
public class MethodAdapter implements MethodFieldAdapter {
    private Method mMethod;

    public MethodAdapter(Method method) {
        mMethod = method;
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return mMethod.isAnnotationPresent(annotationType);
    }

    @Override
    public boolean isValidForProcessing() {
        return (mMethod.getGenericParameterTypes().length == 1);
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        return mMethod.getAnnotation(annotationType);
    }

    @Override
    public void setAccessible(boolean flag) {
        mMethod.setAccessible(flag);
    }

    @Override
    public Object put(Object receiver, Object args) throws InvocationTargetException, IllegalAccessException {
        return mMethod.invoke(receiver, args);
    }

    @Override
    public Type getGenericParameterTypes() {
        return mMethod.getGenericParameterTypes()[0];
    }

    @Override
    public boolean equals(MethodFieldAdapter o1) {
        return mMethod.equals(o1);
    }

    @Override
    public Class<?> getType() {
        return mMethod.getParameterTypes()[0];
    }

    @Override
    public Package getPackage() {
        return mMethod.getDeclaringClass().getPackage();
    }
}
