package biz.kulik.android.jaxb.library.parser.stringutil;

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
