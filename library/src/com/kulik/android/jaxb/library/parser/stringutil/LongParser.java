package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class LongParser extends PrimitiveJavaWrapperParser<Long> {

    @Override
    public Long valueOf(String value) {
        Long l = null;
        try {
            l = Long.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return l;
    }
}
