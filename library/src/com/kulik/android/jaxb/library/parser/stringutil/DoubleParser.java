package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class DoubleParser extends PrimitiveJavaWrapperParser<Double> {

    @Override
    public Double valueOf(String value) {
        Double d = null;
        d = Double.valueOf(value);
        return d;
    }
}
