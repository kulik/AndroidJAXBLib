package biz.kulik.android.jaxb.library.parser.chache;

import java.lang.reflect.Field;

/**
 * User: kulik
 * Date: 12/12/12
 * Time: 4:05 PM
 */
public class ChacheField {


    private Field mField;
    private String mXmlName;

    public ChacheField(Field field, String xmlName) {
        mField = field;
        mXmlName = xmlName;
    }

    public String getXmlName() {
        return mXmlName;
    }

    public Field getField() {
        return mField;
    }

}
