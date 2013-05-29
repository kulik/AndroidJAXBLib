package biz.kulik.android.jaxb.library.parser.chache;

import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 12/12/12
 * Time: 4:05 PM
 */
public class CacheWrapperEntity extends CacheEntity{

    private String mXmlWrapper;

    public CacheWrapperEntity(MethodFieldAdapter mf, String xmlName, String wrapperName) {
        super(mf, xmlName);
        mXmlWrapper = wrapperName;
    }

    public String getXmlWrapper() {
        return mXmlWrapper;
    }
}
