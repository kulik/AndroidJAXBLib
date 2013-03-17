package biz.kulik.android.jaxb.library.Annotations;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

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
