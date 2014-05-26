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
package com.kulik.android.jaxb.library.Annotations;

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 9:50 AM
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {
        ElementType.PACKAGE,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.PARAMETER
})
public @interface XmlJavaTypeAdapter {

    Class<? extends XmlAdapter> value();

    Class type() default DEFAULT.class;

    static final class DEFAULT {
    }
}
