package biz.kulik.android.jaxb.library.parser.chache;

import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.FieldAdapter;
import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

import java.lang.reflect.Field;

/**
 * User: kulik
 * Date: 12/12/12
 * Time: 4:05 PM
 */
public class CacheEntity {

    private MethodFieldAdapter mMethodField;
    private String mXmlName;

    public CacheEntity(MethodFieldAdapter mf, String xmlName) {
        mMethodField = mf;
        mXmlName = xmlName;
    }

    public String getXmlName() {
        return mXmlName;
    }


    public MethodFieldAdapter getMethodField() {
        return mMethodField;
    }
}
