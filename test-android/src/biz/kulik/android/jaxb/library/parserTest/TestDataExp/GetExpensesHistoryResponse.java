package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 31.01.13
 * Time: 11:41
 */
public class GetExpensesHistoryResponse {


    private static final String TAG = GetExpensesHistoryResponse.class.getSimpleName();


    @XmlElement(name = "PRV_WRKR_SAVED_SUB")
    private List<PRV_WRKR_SAVED_SUB> historyEXPCom;


//    @XmlElement(name = "PRV_WORKER_SAVED")
//    private PRV_WORKER_SAVED historyEXPCSaved;
//
//    public PRV_WORKER_SAVED getHistoryEXPCSaved() {
//        return historyEXPCSaved;
//    }
//
//    public void setHistoryEXPCSaved(PRV_WORKER_SAVED historyEXPCSaved) {
//        this.historyEXPCSaved = historyEXPCSaved;
//    }

}