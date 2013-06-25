package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:18 PM
 */
public class PrimitiveBooleanParser  extends PrimitiveParser<Boolean> {

    @Override
    public Boolean valueOf(String value) {
        return Boolean.valueOf(value);
    }
}
