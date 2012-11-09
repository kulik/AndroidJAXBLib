package biz.kulik.android.jaxb.library.parserTest.TestData2;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:44 PM
 */
public class TestStorage {

    @XmlElement(name = "data")
    public List<FavoritePropertyResponse> mFavoritePropertyResponses;

}
