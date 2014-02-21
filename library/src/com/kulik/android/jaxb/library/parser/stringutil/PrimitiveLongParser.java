package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:13 PM
 */
public class PrimitiveLongParser extends PrimitiveParser<Long> {
    @Override
    public Long valueOf(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return 0l;
    }
}
