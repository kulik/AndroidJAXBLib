package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:03
 */
public class HomeExpTypeCom implements Serializable {

    @XmlElement(name = "AlertExpDetail")
    private List<AlertExpDetail> alertExpDetail;

}
