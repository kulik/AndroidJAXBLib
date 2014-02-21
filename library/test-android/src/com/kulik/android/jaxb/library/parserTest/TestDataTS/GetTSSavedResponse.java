package com.kulik.android.jaxb.library.parserTest.TestDataTS;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: bender
 * Date: 28.01.13
 * Time: 19:57
 */
public class GetTSSavedResponse {


    private static final String TAG = GetTSSavedResponse.class.getSimpleName();

    @XmlElement(name = "TSCom")
    public TSCom tsCom;

}