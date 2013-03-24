package biz.kulik.android.jaxb.library.parserTest.TestDataTS;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 13.02.13
 * Time: 15:46
 */
public class DayCom implements Serializable{

    @XmlElement(name = "Day")
    private List<Day> day;

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }
}
