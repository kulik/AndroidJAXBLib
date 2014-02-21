package com.kulik.android.jaxb.library.parserTest.TS_Roster;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 23.01.13
 * Time: 19:05
 */
public class WoCollCmp implements Serializable {

    private static final String TAG = WoCollCmp.class.getSimpleName();


    @XmlElement(name = "WoCollection")
    private List<WoCollection> woCollection;

    public List<WoCollection> getWoCollection() {
        return woCollection;
    }
}
