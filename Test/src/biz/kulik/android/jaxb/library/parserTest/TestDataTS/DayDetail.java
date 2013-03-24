package biz.kulik.android.jaxb.library.parserTest.TestDataTS;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 28.01.13
 * Time: 20:23
 */
public class DayDetail implements Serializable {

    @XmlElement(name = "DISTRIB_NBR")
    private String destribNbr;

    @XmlElement(name = "LINE_NBR")
    private Integer lineNbr;

    @XmlElement(name = "ACTIVITY")
    private String activity;

    @XmlElement(name = "ACTIVITY_ID")
    private String activityId;

    @XmlElement(name = "LINE_DETAILS")
    private String lineDetails;

    @XmlElement(name = "Hours")
    private Double hours = 0.0;

    @XmlElement(name = "START_TIME")
    private String startTime;

    @XmlElement(name = "STOP_TIME")
    private String stopTime;

    @XmlElement(name = "BREAK")
    private String breakTm;

    @XmlElement(name = "DATE_SEQ")
    private Integer dateSeq;

    public String getDestribNbr() {
        return destribNbr;
    }

    public int getLineNbr() {
        return lineNbr;
    }

    public String getActivity() {
        return activity;
    }

    public String getActivityId() {
        return activityId;
    }

    public String getLineDetails() {
        return lineDetails;
    }

    public double getHours() {
        return hours;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public String getBreakTm() {
        return breakTm;
    }

    public int getDateSeq() {
        return dateSeq;
    }

    public void setDestribNbr(String destribNbr) {
        this.destribNbr = destribNbr;
    }

    public void setLineNbr(Integer lineNbr) {
        this.lineNbr = lineNbr;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setLineDetails(String lineDetails) {
        this.lineDetails = lineDetails;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public void setBreakTm(String breakTm) {
        this.breakTm = breakTm;
    }

    public void setDateSeq(Integer dateSeq) {
        this.dateSeq = dateSeq;
    }

    @Override
    public String toString() {
        return "Activity = " + activity + " Line number = " + lineNbr + " Hours = " + hours;
    }
}
