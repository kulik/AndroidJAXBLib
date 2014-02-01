package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class IntegerParser extends PrimitiveJavaWrapperParser<Integer> {

    @Override
    public Integer valueOf(String value) {
        Integer i = null;
        i = Integer.valueOf(value);
        return i;
    }
}
