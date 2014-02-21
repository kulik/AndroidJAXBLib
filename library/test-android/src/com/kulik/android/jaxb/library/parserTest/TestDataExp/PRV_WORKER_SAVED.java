package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 17:43
 */
public class PRV_WORKER_SAVED  implements Serializable {


    @XmlElement(name = "PRV_WRKR_SAVED_SUB")
    private List<PRV_WRKR_SAVED_SUB> prv_wrkr_saved_subs;

}