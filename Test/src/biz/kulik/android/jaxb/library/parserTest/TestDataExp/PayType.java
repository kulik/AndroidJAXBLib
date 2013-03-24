package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:03
 */
public class PayType implements Serializable {


    @XmlElement(name = "Paytype")
    private String  payType;

    @XmlElement(name = "paytypedescr")
    private String  paytypeDescr;

}
