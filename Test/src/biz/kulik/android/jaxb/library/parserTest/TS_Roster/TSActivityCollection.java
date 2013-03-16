package biz.kulik.android.jaxb.library.parserTest.TS_Roster;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 17:54
 */
public class TSActivityCollection implements Serializable {
    private static final String TAG = TSActivityCollection.class.getSimpleName();

    @XmlElement(name = "TSActivity")
    private List<TSActivity> tSActivity;

    public List<TSActivity> getTSactivity() {
        return tSActivity;
    }
}