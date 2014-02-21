package com.kulik.android.jaxb.library.parserTest.TestDataTS;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 13.02.13
 * Time: 15:49
 */
public class DayDetailCom implements Serializable {

    @XmlElement(name = "DayDetail")
    private List<DayDetail> dayDetail;

}
