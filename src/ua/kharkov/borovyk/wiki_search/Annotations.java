package ua.kharkov.borovyk.wiki_search;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/18/12
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
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
