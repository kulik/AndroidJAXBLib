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
    public Class<?> getInputType() {
        return mMethod.getParameterTypes()[0];
    }

    @Override
    public Class<?> getOutputType() {
        return mMethod.getReturnType();
    }

    @Override
    public Class<?> getClassClass() {
        return mMethod.getDeclaringClass();
    }

    @Override
    public Package getPackage() {
        return mMethod.getDeclaringClass().getPackage();
    }

    @Override
    public String getSignature() {
        return mMethod.toString();
    }

    @Override
    public String toString() {
        return mMethod.toString();
    }
}
