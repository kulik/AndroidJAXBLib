package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:16 PM
 */
public class PrimitiveShortParser extends PrimitiveParser<Short> {
    @Override
    public Short valueOf(String value) {
        return Short.valueOf(value);
    }
}
