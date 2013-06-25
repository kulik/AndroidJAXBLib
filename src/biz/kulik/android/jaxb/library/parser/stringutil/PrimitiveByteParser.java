package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:11 PM
 */
public class PrimitiveByteParser implements SimpleTypeParser {
    @Override
    public Object valueOf(String value) {
        return Byte.valueOf(value);
    }
}
