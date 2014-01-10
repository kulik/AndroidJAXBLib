package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * Created by kulik on 1/9/14.
 */
public class ExeptionUtil {
    public static void processInstantiationExceptions(Throwable e, Class clazz) throws IllegalAccessException {
        throw new IllegalAccessException(e.getMessage() + " class name:" +
                ((clazz != null) ? clazz.getName() : "") + " maybe you use this class as inner " +
                "class, so we cant instantiate that outer from that, or maybe private modifier exist");

    }
}
