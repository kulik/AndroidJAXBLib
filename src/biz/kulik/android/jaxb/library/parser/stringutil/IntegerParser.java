package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class IntegerParser implements SimpleTypeParser<Integer>{

    @Override
    public Integer valueOf(String value) {
        Integer i = null;
        try {
            i = Integer.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return i;
    }
}
