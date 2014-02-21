package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:00
 */
public class    HomeExpColl implements Serializable {

    @XmlElement(name = "HomeExpTypeColl")
    private List<HomeExpTypeColl> homeExpTypeColl;

    public List<HomeExpTypeColl> getHomeExpTypeColl() {
        return homeExpTypeColl;
    }

    public void setHomeExpTypeColl(List<HomeExpTypeColl> homeExpTypeColl) {
        this.homeExpTypeColl = homeExpTypeColl;
    }
}
