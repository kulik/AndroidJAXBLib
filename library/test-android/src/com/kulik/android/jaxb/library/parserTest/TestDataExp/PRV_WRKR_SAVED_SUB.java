package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 14.02.13
 * Time: 15:16
 */
public class PRV_WRKR_SAVED_SUB implements Serializable {

    @XmlElement(name = "CREATION_DT")
    private String creationDate;

    @XmlElement(name = "TXN_AMOUNT")
    private Double taxAmount = 0.0;

    @XmlElement(name = "SHEET_ID")
    private String sheetID;

    @XmlElement(name = "BU")
    private String businessUnit;

    @XmlElement(name = "SHEET_STATUS")
    private String status;

    @XmlElement(name = "APPROVED")
    private String approveDt;

    @XmlElement(name = "DENIED")
    private String deniedDt;

    @XmlElement(name = "BUS_PUR")
    private String businessPurpose;

    @XmlElement(name = "WO_ID")
    private String woID;

    @XmlElement(name = "REFERENCE")
    private String reference;

    @XmlElement(name = "HomeExpColl")
    private HomeExpColl homeExpColl;

    @XmlElement(name = "SelectionDetailCollection")
    private SelectionDetailCollection selectionDetailCollection;

    @XmlElement(name = "paytypeCom")
    private PaytypeCom paytypeCom;

    @XmlElement(name = "BillingActionCom")
    private BillingActionCom billingActionCom;

    @XmlElement(name = "Approver")
    private String approver;

    @XmlElement(name = "BUS_PUR_DESCR")
    private String businessPurpDescr;

    public String getBusinessPurpDescr() {
        return businessPurpDescr;
    }

    public void setBusinessPurpDescr(String businessPurpDescr) {
        this.businessPurpDescr = businessPurpDescr;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproveDt() {
        return approveDt;
    }

    public void setApproveDt(String approveDt) {
        this.approveDt = approveDt;
    }

    public String getDeniedDt() {
        return deniedDt;
    }

    public void setDeniedDt(String deniedDt) {
        this.deniedDt = deniedDt;
    }

    public String getBusinessPurpose() {
        return businessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        this.businessPurpose = businessPurpose;
    }

    public String getWoID() {
        return woID;
    }

    public void setWoID(String woID) {
        this.woID = woID;
    }

}
