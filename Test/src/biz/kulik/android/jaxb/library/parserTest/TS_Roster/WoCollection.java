package biz.kulik.android.jaxb.library.parserTest.TS_Roster;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:55
 */
public class WoCollection implements Serializable {

    private static final String TAG = WoCollection.class.getSimpleName();

    @XmlElement(name = "BUSINESS_UNIT")
    private String businessUnit;

    @XmlElement(name = "WORK_ORDER_ID")
    private String workOrderID;

    @XmlElement(name = "JOB_TITLE")
    private String jobTitle;

    @XmlElement(name = "USE_CLOCK")
    private String useClock;

    @XmlElement(name = "DistribCollection")
    private List<String> destributionCollection;

    @XmlElement(name = "TSActivityCollection")
    private List<TSActivity> TSActivityCollection;

}