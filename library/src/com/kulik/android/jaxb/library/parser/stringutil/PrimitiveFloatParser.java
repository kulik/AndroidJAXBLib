package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:17 PM
 */
public class PrimitiveFloatParser extends PrimitiveParser<Float> {

    @Override
    public Float valueOf(String value) {
        try {
            return Float.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return 0f;
    }
}
