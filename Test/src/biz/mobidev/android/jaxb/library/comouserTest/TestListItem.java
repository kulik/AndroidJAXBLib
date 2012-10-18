package biz.mobidev.android.jaxb.library.comouserTest;

import biz.mobidev.android.jaxb.library.Annotations;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:46 PM
 */
public class TestListItem {
    @Annotations.Value(name = "item_value")
    Integer mItval;

    TestListItem(int val) {
        mItval = Integer.valueOf(val);
    }
}
