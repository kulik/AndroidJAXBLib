package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:03
 */
public class BillingAction implements Serializable {


    @XmlElement(name = "BillAct")
    private String billAct;


}
