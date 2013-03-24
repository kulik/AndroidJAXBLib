package biz.kulik.android.jaxb.library.parserTest.TestDataTS;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 28.01.13
 * Time: 20:12
 */
public class Day implements Serializable {

    @XmlElement(name = "Day")
    private String day;

    @XmlElement(name = "TotalHours")
    private Double totalHours;

    @XmlElement(name = "DayDetailCom")
    private DayDetailCom dayDetailCom;


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public DayDetailCom getDayDetailCom() {
        return dayDetailCom;
    }

    public void setDayDetailCom(DayDetailCom dayDetailCom) {
        this.dayDetailCom = dayDetailCom;
    }
}
