package biz.kulik.android.jaxb.library.parserTest.TestData3;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 11/6/12
 * Time: 3:20 PM
 */

//@XmlRootElement(name = "ViewingTime")
public class ViewingTime {

    @XmlElement(name = "ordering")
    private int ordering;

    @XmlElement(name = "fromTime")
    //@XmlJavaTypeAdapter(DateTimeAdapter.class) Data
    private String fromTime;

    @XmlElement(name = "toTime")
    //@XmlJavaTypeAdapter(DateTimeAdapter.class) Data
    private String toTime;
}
