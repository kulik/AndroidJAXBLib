package biz.mobidev.android.jaxb.library;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 12:23 PM
 */
public class Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Value {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Attribute {
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface PathWrapper {
        String path();
    }


}
