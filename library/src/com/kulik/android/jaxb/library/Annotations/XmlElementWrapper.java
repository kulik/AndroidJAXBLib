package com.kulik.android.jaxb.library.Annotations;

import com.kulik.android.jaxb.library.Annotations.adapters.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * User: kulik
 * Date: 3/14/13
 * Time: 10:07 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementWrapper {
    String name();
    String namespace() default Constants.ANY_NS;
}
