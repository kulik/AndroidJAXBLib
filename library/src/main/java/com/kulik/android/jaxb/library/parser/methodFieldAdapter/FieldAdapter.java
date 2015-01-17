/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
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

    @Override
    public String getSignature() {
        return mField.toString();
    }

    @Override
    public String toString() {
        return mField.toString();
    }
}
