package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class FloatParser extends PrimitiveJavaWrapperParser<Float> {

    @Override
    public Float valueOf(String value) {
        Float f = null;
        f = Float.valueOf(value);
        return f;
    }
}
