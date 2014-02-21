package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: bender
 * Date: 31.01.13
 * Time: 11:41
 */
public class GetExpensesSavedResponse {

    @XmlElement(name = "PRV_WRKR_SAVED_SUB")
    private List<PRV_WRKR_SAVED_SUB> prv_wrkr_saved_subs;

}