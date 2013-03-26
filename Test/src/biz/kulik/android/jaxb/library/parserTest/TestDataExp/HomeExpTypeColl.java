package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:03
 */
public class HomeExpTypeColl implements Serializable {


    @XmlElement(name = "BUSINESS_UNIT")
    private String  businessUnit;

    @XmlElement(name = "HomeExpTypeCom")
    private HomeExpTypeCom  homeExpTypeCom;

    @XmlElement(name = "BPDetailsCom")
    private BPDetailsCom  bPDetailsCom;

    @XmlElement(name = "paytypeCom")
    private PaytypeCom  paytypeCom;

    @XmlElement(name = "BillingActionCom")
    private BillingActionCom  billingActionCom;

}
