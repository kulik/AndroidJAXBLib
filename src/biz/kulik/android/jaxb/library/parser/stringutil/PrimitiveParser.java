package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 9:16 PM
 */
public abstract class PrimitiveParser<T> implements SimpleTypeParser<T> {

    @Override
    public boolean isPrimitiveType() {
        return true;
    }
}
