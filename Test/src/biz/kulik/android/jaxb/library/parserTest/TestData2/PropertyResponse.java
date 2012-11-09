package biz.kulik.android.jaxb.library.parserTest.TestData2;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
//@XmlRootElement(name = "properties")
public class PropertyResponse {

    @XmlElement(name = "adid")
    public Integer adID;

    @XmlElement(name = "mainImageUrl")
    public String mainImageUrl;

    @XmlElement(name = "priceSuggestion")
    public Integer priceSuggestion;

    @XmlElement(name = "address")
    public String address;

    @XmlElement(name = "postcode")
    public String postCode;

    @XmlElement(name = "location")
    public String location;

    @XmlElement(name = "sold")
    public Boolean sold;

}
