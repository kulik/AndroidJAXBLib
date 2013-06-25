package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:18 PM
 */
public class PrimitiveDoubleParser implements SimpleTypeParser<Double> {
    @Override
    public Double valueOf(String value) {
        return Double.valueOf(value);
    }
}
