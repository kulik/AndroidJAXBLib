package biz.mobidev.android.jaxb.library.parserTest;

import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 10/26/12
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStorage {

    @XMLValue(name="data")
    private List<FavoritePropertyResponse> mFavoritePropertyResponses;// = new ArrayList<FavoritePropertyResponse>();

}
