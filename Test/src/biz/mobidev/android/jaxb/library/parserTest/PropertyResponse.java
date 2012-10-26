package biz.mobidev.android.jaxb.library.parserTest;

import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertyResponse {

    @XMLValue(name = "adid")
    public Integer adID;

    @XMLValue(name = "mainImageUrl")
    public String mainImageUrl;

    @XMLValue(name = "priceSuggestion")
    public Integer priceSuggestion;

    @XMLValue(name = "address")
    public String address;

    @XMLValue(name = "postcode")
    public String postCode;

    @XMLValue(name = "location")
    public String location;

    @XMLValue(name = "sold")
    public Boolean sold;

}
