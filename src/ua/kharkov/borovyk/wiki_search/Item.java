package ua.kharkov.borovyk.wiki_search;

import android.net.Uri;
import android.util.Log;
import ua.kharkov.borovyk.wiki_search.mynetwork.Annotations;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/5/12
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item implements Serializable {

    private static final String TAG = Item.class.getSimpleName();

    private String title;
    private String pic;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item() {
    }

    public Item(String title, String pic, String url) {
        this.title = title;
        this.pic = pic;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Title=" + title + ", picture=" + pic + ", url=" + url;
    }


}
