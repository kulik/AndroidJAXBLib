package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: bender
 * Date: 14.02.13
 * Time: 15:23
 */
public class PRV_WRKR_SAVED_SELECT {

//    @XmlElement(name = "BP")
//    private String bp;
//
//    @XmlElement(name = "BP_DESCR")
//    private String bpDescr;

    @XmlElement(name = "SelectionDetailCollection")
    private SelectionDetailCollection selectionDetailCollection;

    @XmlElement(name = "HomeExpTypeCom")
    private HomeExpTypeCom homeExpTypeCom;

    @XmlElement(name = "paytypeCom")
    private PaytypeCom paytypeCom;

    @XmlElement(name = "BillingActionCom")
    private BillingActionCom billingActionCom;

}
