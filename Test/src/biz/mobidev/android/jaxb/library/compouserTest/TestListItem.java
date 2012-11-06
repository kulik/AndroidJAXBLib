package biz.mobidev.android.jaxb.library.compouserTest;

import biz.mobidev.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:46 PM
 */
public class TestListItem {
    @XmlElement(name = "item_value")
    Integer mItval;

    TestListItem(int val) {
        mItval = Integer.valueOf(val);
    }
}
