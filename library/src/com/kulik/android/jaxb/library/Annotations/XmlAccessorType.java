package com.kulik.android.jaxb.library.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 3:57 PM
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE, ElementType.TYPE})
public @interface XmlAccessorType {

    public static enum AccessType {

        FIELD,
        NONE,
        PROPERTY,
        PUBLIC_MEMBER
    }
}
