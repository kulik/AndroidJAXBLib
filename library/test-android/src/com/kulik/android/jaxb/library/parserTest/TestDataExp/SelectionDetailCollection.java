package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 14.02.13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class SelectionDetailCollection implements Serializable {

    @XmlElement(name = "PRV_WRKR_SAVED_SLCT_DTL")
    public List<PRV_WRKR_SAVED_SLCT_DTL> PRV_WRKR_SAVED_SLCT_DTL;

}
