package biz.mobidev.android.jaxb.library.comouserTest;

import biz.mobidev.android.jaxb.library.Annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:40 PM
 */
public class RootProxy {
    @Annotations.Value(name="B")
    BProxy mb = new BProxy();

    @Annotations.Value(name="A")
    AProxy ma = new AProxy();

    @Annotations.Value(name="TestList")
    List<TestListItem> mlist = new ArrayList<TestListItem>(Arrays.asList(new TestListItem[] {new TestListItem(122), new TestListItem(123)}));

    @Annotations.Value(name="TestIntegerValue")
    Integer mTestIntegerVal = Integer.valueOf(12212);

}
