package biz.kulik.android.jaxb.library.parserTest.parserDima21;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

public class Response {
    @XmlElement(name = "data")
    public List<ApartmentResponse> mApartments;

    public static class ApartmentResponse {
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

        @XmlElement(name = "favorited")
        public Boolean favorited;
    }
}