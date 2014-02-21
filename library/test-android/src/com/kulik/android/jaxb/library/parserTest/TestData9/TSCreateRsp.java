package com.kulik.android.jaxb.library.parserTest.TestData9;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class TSCreateRsp {

    @XmlElement(name = "textS")
    public String textS;

    @XmlElement(name = "text")
    public List<String> text;
}