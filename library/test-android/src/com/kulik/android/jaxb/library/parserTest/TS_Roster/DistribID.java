package com.kulik.android.jaxb.library.parserTest.TS_Roster;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:53
 */
public class DistribID implements Serializable {
    private static final String TAG = DistribID.class.getSimpleName();

    @XmlElement(name = "DISTRIB_ID")
    private String destributionID;

    public String getDestributionID() {
        return destributionID;
    }
}
