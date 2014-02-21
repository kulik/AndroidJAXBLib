package com.kulik.android.jaxb.library.parserTest.TestData5;

import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.parserTest.TS_Roster.WoCollection;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 16.01.13
 * Time: 17:56
 * To change this template use File | Settings | File Templates.
 */
public class DateCollectionCh implements Serializable {

    private static final String TAG = DateCollectionCh.class.getSimpleName();

    @XmlElement(name = "EndDate")
    private String endDate;

    @XmlElement(name = "StartDate")
    private String startDate;


    @XmlElement(name = "WoCollection")
    private List<WoCollection> woCollection;

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public List<WoCollection> getWoCollection() {
        return woCollection;
    }


}