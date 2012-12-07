package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class FloatParser implements SimpleTypeParser<Float>{

    @Override
    public Float valueOf(String value) {
        Float f = null;
        try {
            f = Float.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return f;
    }
}
