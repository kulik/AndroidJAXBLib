package com.kulik.android.jaxb.library.parser.chache;

import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

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
