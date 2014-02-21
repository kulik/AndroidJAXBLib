package com.kulik.android.jaxb.library.compouserTest.testWrapper;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlRootElement;

/**
 * Created by kulik on 1/8/14.
 */
@XmlRootElement(name = "soap:Envelope")
public class SoapRoot {

    @XmlAttribute(name = "xmlns:soap")
    private String xmlnsSoap = "http://schemas.xmlsoap.org/soap/envelope/";
    @XmlAttribute(name = "xmlns:t")
    private String xmlnsT = "http://schemas.microsoft.com/exchange/services/2006/types";

    @XmlElement(name = "soap:Body")
    EWSRequest body;

}
