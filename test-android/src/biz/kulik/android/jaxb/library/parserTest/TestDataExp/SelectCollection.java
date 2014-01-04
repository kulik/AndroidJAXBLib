package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 14.02.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class SelectCollection implements Serializable {

//    @XmlElement(name = "PRV_WRKR_SAVED_SELECT")
//    private PRV_WRKR_SAVED_SELECT prvWrkrSavedSelects;
//
//    public PRV_WRKR_SAVED_SELECT getPrvWrkrSavedSelects() {
//        return prvWrkrSavedSelects;
//    }
//
//    public void setPrvWrkrSavedSelects(PRV_WRKR_SAVED_SELECT prvWrkrSavedSelects) {
//        this.prvWrkrSavedSelects = prvWrkrSavedSelects;
//    }

    @XmlElement(name = "PRV_WRKR_SAVED_SLCT_DTL")
    public List<PRV_WRKR_SAVED_SLCT_DTL> prvWrkrSelectDtl;

}
