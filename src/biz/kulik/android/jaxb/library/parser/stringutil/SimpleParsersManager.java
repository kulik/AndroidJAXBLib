package biz.kulik.android.jaxb.library.parser.stringutil;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:28 PM
 */
public class SimpleParsersManager {

    private static final HashMap<Class<?>, SimpleTypeParser> SIMPLE_TYPE_PARSERS = new HashMap<Class<?>, SimpleTypeParser>(6) {{
        put(Integer.class, new IntegerParser());
        put(Double.class, new DoubleParser());
        put(Float.class, new FloatParser());
        put(Boolean.class, new BooleanParser());
        put(Long.class, new LongParser());
        put(BigDecimal.class, new BigDecimalParser());
    }};



    public static SimpleTypeParser getParser(Class<?> clazz) {
        SimpleTypeParser parser = SIMPLE_TYPE_PARSERS.get(clazz);
        return parser;
    }
}
