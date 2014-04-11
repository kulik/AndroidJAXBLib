package com.kulik.android.jaxb.library.Annotations;

import com.kulik.android.jaxb.library.Annotations.adapters.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * User: kulik
 * Date: 10/25/12
 * Time: 4:42 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElement {
    String name();
    String namespace() default Constants.ANY_NS;
}
