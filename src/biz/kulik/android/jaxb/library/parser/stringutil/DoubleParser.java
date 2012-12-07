package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class DoubleParser implements SimpleTypeParser<Double> {

    @Override
    public Double valueOf(String value) {
        Double d = null;
        try {
            d = Double.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return d;
    }
}
