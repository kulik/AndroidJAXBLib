package com.kulik.android.jaxb.library.parser;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 11:06 AM
 */
public interface Parser {
    <T> T parse(Class<T> cls, InputStream data) throws Exception;

    <T> T parse(Class<T> cls, String data) throws Exception;
}
