package com.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 9:16 PM
 */
public class StringParser extends PrimitiveJavaWrapperParser<String> {
    @Override
    public String valueOf(String value) {
        return value;
    }
}
