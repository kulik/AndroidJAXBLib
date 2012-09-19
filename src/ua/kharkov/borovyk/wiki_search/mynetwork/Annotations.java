package ua.kharkov.borovyk.wiki_search.mynetwork;

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
    public @interface XMLValue{
        String name();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface XMLAttribute{
        String name();
    }
}
