package biz.kulik.android.jaxb.library.parserTest.TS_Roster;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:56
 */
public class DateCollectionCh implements Serializable {
    private static final String TAG = DateCollectionCh.class.getSimpleName();

    @XmlElement(name = "EndDate")
    private String endDate;

    @XmlElement(name = "StartDate")
    private String startDate;

    @XmlElement(name = "WoCollCmp")
    private List<WoCollection> woCollCmp;

}