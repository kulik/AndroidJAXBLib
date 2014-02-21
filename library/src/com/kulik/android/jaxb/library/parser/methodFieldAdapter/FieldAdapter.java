package com.kulik.android.jaxb.library.parser.methodFieldAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 5:10 PM
 */
public class FieldAdapter implements MethodFieldAdapter {
    private Field mField;

    public FieldAdapter(Field field) {
        mField = field;
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return mField.isAnnotationPresent(annotationType);
    }

    @Override
    public boolean isValidForProcessing() {
        return true;
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        return mField.getAnnotation(annotationType);
    }

    @Override
    public void setAccessible(boolean flag) {
        mField.setAccessible(flag);
    }

    @Override
    public Object put(Object receiver, Object args) throws InvocationTargetException, IllegalAccessException {
        mField.set(receiver, args);
        return mField;
    }

    @Override
    public Type getGenericParameterTypes() {
        return mField.getGenericType();
    }

    @Override
    public boolean equals(MethodFieldAdapter o1) {
        return mField.equals(o1);
    }

    @Override
    public Class<?> getInputType() {
        return mField.getType();
    }

    @Override
    public Class<?> getOutputType() {
        return mField.getType();
    }

    @Override
    public Class<?> getClassClass() {
        return mField.getDeclaringClass();
    }

    @Override
    public Package getPackage() {
        return mField.getDeclaringClass().getPackage();
    }
}
