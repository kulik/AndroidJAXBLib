package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:12 PM
 */
public class PrimitiveIntegerParser extends PrimitiveParser<Integer> {
    @Override
    public Integer valueOf(String value) {
        return Integer.valueOf(value);
    }
}
