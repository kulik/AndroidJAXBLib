package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:17 PM
 */
public class PrimitiveFloatParser implements SimpleTypeParser<Float> {

    @Override
    public Float valueOf(String value) {
        return Float.valueOf(value);
    }
}
