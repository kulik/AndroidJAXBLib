package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 14.02.13
 * Time: 15:29
 */
public class PRV_WRKR_SAVED_SLCT_DTL implements Serializable {


    @XmlElement(name = "EXP_AMOUNT")
    private Double expenseAmount;

    @XmlElement(name = "COMMENTS")
    private String comments;

    @XmlElement(name = "LINE_NBR")
    private String lineNumber;

    @XmlElement(name = "TRANS_DATE")
    private String transDate;

    @XmlElement(name = "EXPENSE_TYPE")
    private String expenseType;

    @XmlElement(name = "EXPENSE_TYPE_DESCR")
    private String expenseDescription;


    @XmlElement(name = "FIELD_NAME")
    private String fieldName;

    @XmlElement(name = "FIELD_TYPE")
    private String fieldType;

    @XmlElement(name = "FIELD_VALUE")
    private String fieldValue;

    @XmlElement(name = "BILLING_ACTION")
    private String billingAction;

    @XmlElement(name = "PAYMENT_TYPE")
    private String paymentType;

    @XmlElement(name = "VAT_ENTRD_AMT")
    private double vatAmount;

    @XmlElement(name = "SALESTX_AMT")
    private double salesTax;

}
