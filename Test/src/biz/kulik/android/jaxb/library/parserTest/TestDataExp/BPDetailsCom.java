package biz.kulik.android.jaxb.library.parserTest.TestDataExp;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:03
 */
public class BPDetailsCom implements Serializable {


    @XmlElement(name = "BPDetails")
    private List<BPDetails> bPDetails;

}
