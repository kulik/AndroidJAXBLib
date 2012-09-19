package ua.kharkov.borovyk.wiki_search;

import android.app.DownloadManager;
import android.nfc.Tag;
import android.util.Log;
import android.widget.ImageButton;
import ua.kharkov.borovyk.wiki_search.mynetwork.Annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchSuggestion {
    private static final String TAG = SearchSuggestion.class.getSimpleName();

    @Annotations.XMLValue(name="Section")
    private Section section;

    public Section getQuery() {
        return section;
    }

    public void setQuery(Section query) {
        this.section = query;
    }

    public static class Section {
        private static final String TAG = Section.class.getSimpleName();
        @Annotations.XMLValue(name="Item")
        private Item[] item;

//        public List<Item> getItem() {
//            return item;
//        }

        public Section() {
            Log.v(TAG, "Section constructor");
        }
//        public void setItem(List<Item> item) {
//            this.item = item;
//        }

        public static class Item {

            private static final String TAG = Item.class.getSimpleName();

            @Annotations.XMLValue(name = "Text")
            private String title;
            @Annotations.XMLValue(name = "Image")
            private Image image;
            @Annotations.XMLValue(name = "Url")
            private String url;

            public Item() {
                Log.v(TAG, "Constructor.Item");
                title = "";
                image = null;
                url = "";
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Image getImage() {
                return image;
            }

            public void setImage(Image image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class Image {
                @Annotations.XMLAttribute(name="source")
                private String source = "";

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

            }

        }

    }

}
