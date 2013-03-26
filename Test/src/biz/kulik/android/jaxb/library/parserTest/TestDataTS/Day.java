package biz.kulik.android.jaxb.library.parserTest.TestDataTS;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 28.01.13
 * Time: 20:12
 */
public class Day implements Serializable {

//    @XmlElement(name = "Day")
//    private String day;

//    @XmlElement(name = "TotalHours")
//    private Double totalHours;

    @XmlElement(name = "DayDetailCom")
    private DayDetailCom dayDetailCom;


}
