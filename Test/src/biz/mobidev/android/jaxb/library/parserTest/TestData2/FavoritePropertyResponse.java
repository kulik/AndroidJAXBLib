package biz.mobidev.android.jaxb.library.parserTest.TestData2;

import biz.mobidev.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class FavoritePropertyResponse {

    @XmlElement(name = "property")
    public PropertyResponse property;

    @XmlElement(name = "rate")
    public Integer rate;

    //TODO check it that is will be null
//	@XmlElement(name = "comments")
//	public List<Comment> comments;

    @XmlElement(name = "own")
    public Boolean favoritedByUser;

    @XmlElement(name = "friend")
    public Boolean favoritedByFriend;

}
