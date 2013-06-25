package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:09 PM
 */
public class ShortParser extends PrimitiveJavaWrapperParser<Short> {
    @Override
    public Short valueOf(String value) {
        return Short.valueOf(value);
    }
}
