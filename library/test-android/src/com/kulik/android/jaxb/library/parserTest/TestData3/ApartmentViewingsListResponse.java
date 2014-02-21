package com.kulik.android.jaxb.library.parserTest.TestData3;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 11/6/12
 * Time: 3:19 PM
 */
//@XmlRootElement(name = "apartmentViewings")
public class ApartmentViewingsListResponse extends AbstractResponse {
    @XmlElement(name = "property")
    public PropertyResponse propertyResponse;

    @XmlElement(name = "viewingTimes")
    public List<ViewingTime> viewingTimes;
}

