package com.kulik.android.jaxb.library.parser.providers;

import java.util.List;

/**
 * User: nata
 * Date: 9/20/12
 * Time: 12:39 PM
 */
public class ElemJSONStringUnmarshalerImpl implements ElementUnmarshaler {
    private static final String TAG = ElemJSONStringUnmarshalerImpl.class.getSimpleName();

    private static final String stub_wrapper = "SELF";
    private String mWrappedString;

    public ElemJSONStringUnmarshalerImpl(String obj) {
        super();
        mWrappedString = obj;
    }

    @Override
    public List getChildren(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ElementUnmarshaler getChild(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isChildExist(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue(String name) {
//        return mWrappedString;
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return mWrappedString;
    }

    @Override
    public String getAttributeValue(String name) {
        return getValue(name);
    }

}
