package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:13 PM
 */
public class PrimitiveLongParser extends PrimitiveParser<Long> {
    @Override
    public Long valueOf(String value) {
        return Long.valueOf(value);
    }
}
