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
import java.lang.reflect.Type;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 5:07 PM
 */
public interface MethodFieldAdapter {

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType);

    public boolean isValidForProcessing();

    public <A extends Annotation> A getAnnotation(Class<A> annotationType);

    public void setAccessible(boolean flag);

    public Object put(Object receiver, Object args) throws InvocationTargetException, IllegalAccessException;

    public Type getGenericParameterTypes();

    public boolean equals(MethodFieldAdapter o1);

    public Class<?> getInputType();

    public Class<?> getOutputType();

    public Class<?> getClassClass();

    public Package getPackage();

    public String getSignature();

}