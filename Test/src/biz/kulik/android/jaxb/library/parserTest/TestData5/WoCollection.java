package com.worker.rest.responses.roster;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 16.01.13
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
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
    private List<DistribCollection> destributionCollection;



    @XmlElement(name = "ActivityCollection")
    private List<ActivityCollection> activityCollection;



    public String getBusinessUnit() {
        return businessUnit;
    }

    public String getWorkOrderID() {
        return workOrderID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getUseClock() {
        return useClock;
    }

    public List<DistribCollection> getDestributionCollection() {
        return destributionCollection;
    }

    public List<ActivityCollection> getActivityCollection() {
        return activityCollection;
    }
}