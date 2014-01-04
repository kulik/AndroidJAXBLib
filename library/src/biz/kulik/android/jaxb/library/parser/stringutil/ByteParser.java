package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:10 PM
 */
public class ByteParser extends PrimitiveJavaWrapperParser<Byte> {

    @Override
    public Byte valueOf(String value) {
        return Byte.valueOf(value);
    }
}
