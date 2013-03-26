package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 15.02.13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class AlertExpDetail implements Serializable {

    @XmlElement(name = "ExpType")
    public String expType;

    @XmlElement(name = "Exptype_Descr")
    public String exptype_Descr;

    @XmlElement(name = "FieldName")
    public String fieldName;

    @XmlElement(name = "Fieldtype")
    public String fieldType;

    @XmlElement(name = "FieldValue")
    public String fieldValue;

    @XmlElement(name = "ExpTypeEdit")
    public String expTypeEdit;

    @XmlElement(name = "TaxImplFlg")
    public String taxImplFlg;

    @XmlElement(name = "SalesTax")
    public String salesTax;

    @XmlElement(name = "VATAmount")
    public String vatAmount;

}
