package com.kulik.android.jaxb.library.parserTest.TestDataTS;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 13.02.13
 * Time: 15:46
 */
public class DayCom implements Serializable{

    @XmlElement(name = "Day")
    public List<Day> day;

}