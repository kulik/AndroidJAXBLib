/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.parser.stringutil;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:28 PM
 */
public class SimpleParsersManager {
    //TODO use LazyMap
    //TODO throw exceptions from parsers, and log it's

    private static final HashMap<Class<?>, SimpleTypeParser> SIMPLE_TYPE_PARSERS = new HashMap<Class<?>, SimpleTypeParser>(16) {{
        put(Integer.class, new IntegerParser());
        put(Double.class, new DoubleParser());
        put(Float.class, new FloatParser());
        put(Boolean.class, new BooleanParser());
        put(Long.class, new LongParser());
        put(BigDecimal.class, new BigDecimalParser());
        put(Short.class, new ShortParser());
        put(Byte.class, new ByteParser());
        put(String.class, new StringParser());

        //Primitive Java Types
        put(Byte.TYPE, new PrimitiveByteParser());
        put(Integer.TYPE, new PrimitiveIntegerParser());
        put(Long.TYPE, new PrimitiveLongParser());
        put(Short.TYPE, new PrimitiveShortParser());
        put(Float.TYPE, new PrimitiveFloatParser());
        put(Double.TYPE, new PrimitiveDoubleParser());
        put(Boolean.TYPE, new PrimitiveBooleanParser());
    }};


    public static SimpleTypeParser getParser(Class<?> clazz) {
        SimpleTypeParser parser = SIMPLE_TYPE_PARSERS.get(clazz);
        return parser;
    }
}
