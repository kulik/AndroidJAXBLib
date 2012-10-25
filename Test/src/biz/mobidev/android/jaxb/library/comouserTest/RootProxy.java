package biz.mobidev.android.jaxb.library.comouserTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:40 PM
 */
public class RootProxy {
    @Annotations.XMLValue(name="B")
    BProxy mb = new BProxy();

    @Annotations.XMLValue(name="A")
    AProxy ma = new AProxy();

    @Annotations.XMLValue(name="TestList")
    List<TestListItem> mlist = new ArrayList<TestListItem>(Arrays.asList(new TestListItem[] {new TestListItem(122), new TestListItem(123)}));

    @Annotations.XMLValue(name="TestIntegerValue")
    Integer mTestIntegerVal = Integer.valueOf(12212);

}
