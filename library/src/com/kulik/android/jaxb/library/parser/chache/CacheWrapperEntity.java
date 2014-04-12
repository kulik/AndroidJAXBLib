package com.kulik.android.jaxb.library.parser.chache;

import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 12/12/12
 * Time: 4:05 PM
 */
public class CacheWrapperEntity extends CacheEntity {

    private String mXmlWrapper;

    private String mNsWrapper;

    public CacheWrapperEntity(MethodFieldAdapter mf, String xmlName, String ns, String wrapperName, String wrapperNsName) {
        super(mf, xmlName, ns);
        mXmlWrapper = wrapperName;
        mNsWrapper = wrapperNsName;
    }

    public String getXmlWrapper() {
        return mXmlWrapper;
    }

    public String getNSWrapper() {
        return mNsWrapper;
    }
}
