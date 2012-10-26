package biz.mobidev.android.jaxb.library.parserTest;

import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class FavoritePropertyResponse {

    @XMLValue(name = "property")
    public PropertyResponse property;

    @XMLValue(name = "rate")
    public Integer rate;

//	@XMLValue(name = "comments")
//	public List<Comment> comments;

    @XMLValue(name = "own")
    public Boolean favoritedByUser;

    @XMLValue(name = "friend")
    public Boolean favoritedByFriend;

}
