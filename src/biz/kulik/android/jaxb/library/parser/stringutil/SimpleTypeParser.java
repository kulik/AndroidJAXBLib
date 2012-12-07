package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:30 PM
 */
public interface SimpleTypeParser<T> {
    T valueOf(String value);
}
