package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:31 PM
 */
public class BooleanParser extends PrimitiveJavaWrapperParser<Boolean> {

    @Override
    public Boolean valueOf(String value) {
        Boolean b = null;
        try {
            b = Boolean.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return b;
    }
}
