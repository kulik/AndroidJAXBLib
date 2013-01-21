package biz.kulik.android.jaxb.library.parser.stringutil;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * User: kulik
 * Date: 12/6/12
 * Time: 8:28 PM
 */
public class SimpleParsersManager {

    private HashMap<Class<?>, SimpleTypeParser> mSimpleTypeParserList;

    public SimpleParsersManager() {
        mSimpleTypeParserList = new HashMap<Class<?>, SimpleTypeParser>(6);

        mSimpleTypeParserList.put(Integer.class, new IntegerParser());
        mSimpleTypeParserList.put(Double.class, new DoubleParser());
        mSimpleTypeParserList.put(Float.class, new FloatParser());
        mSimpleTypeParserList.put(Boolean.class, new BooleanParser());
        mSimpleTypeParserList.put(Long.class, new LongParser());
        mSimpleTypeParserList.put(BigDecimal.class, new BigDecimalParser());
    }

    public SimpleTypeParser getParser(Class<?> clazz) {
        SimpleTypeParser parser = mSimpleTypeParserList.get(clazz);
        return parser;
    }
}
