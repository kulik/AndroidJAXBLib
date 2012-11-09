package biz.kulik.android.jaxb.library.compouserTest;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: kulik
 * Date: 10/16/12
 * Time: 1:40 PM
 */
public class RootProxy {
    @XmlElement(name="B")
    BProxy mb = new BProxy();

    @XmlElement(name="A")
    AProxy ma = new AProxy();

    @XmlElement(name="TestList")
    List<TestListItem> mlist = new ArrayList<TestListItem>(Arrays.asList(new TestListItem[] {new TestListItem(122), new TestListItem(123)}));

    @XmlElement(name="TestIntegerValue")
    Integer mTestIntegerVal = Integer.valueOf(12212);

}
