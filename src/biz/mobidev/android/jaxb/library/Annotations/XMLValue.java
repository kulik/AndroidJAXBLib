package biz.mobidev.android.jaxb.library.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/25/12
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XMLValue {
    String name();
}
