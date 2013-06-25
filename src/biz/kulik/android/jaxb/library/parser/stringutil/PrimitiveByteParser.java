package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:11 PM
 */
public class PrimitiveByteParser  extends PrimitiveParser<Byte> {
    @Override
    public Byte valueOf(String value) {
        return Byte.valueOf(value);
    }
}
