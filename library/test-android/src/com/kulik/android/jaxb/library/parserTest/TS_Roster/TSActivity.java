package com.kulik.android.jaxb.library.parserTest.TS_Roster;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 25.01.13
 * Time: 18:45
 */
public class TSActivity  implements Serializable {
    private static final String TAG = TSActivity.class.getSimpleName();

    @XmlElement(name = "ACTIVITY_ID")
    private String activityID;

    @XmlElement(name = "DESCR")
    private String description;

}