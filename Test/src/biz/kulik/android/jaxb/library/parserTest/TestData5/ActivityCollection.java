package biz.kulik.android.jaxb.library.parserTest.TestData5;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:54
 */
public class ActivityCollection implements Serializable {

    private static final String TAG = ActivityCollection.class.getSimpleName();

    @XmlElement(name = "ACTIVITY")
    private String activity;

    public String getActivity() {
        return activity;
    }
}