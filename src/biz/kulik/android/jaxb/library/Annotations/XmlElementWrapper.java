package biz.kulik.android.jaxb.library.Annotations;

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
}
