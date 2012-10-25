package biz.mobidev.android.jaxb.library;

import biz.mobidev.android.jaxb.library.Annotations.XMLAttribute;
import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class SearchSuggestion {
    private static final String TAG = SearchSuggestion.class.getSimpleName();

    @XMLValue(name="Section")
    private Section section;

    public Section getQuery() {
        return section;
    }

    public void setQuery(Section query) {
        this.section = query;
    }

    public static class Section {
        private static final String TAG = Section.class.getSimpleName();
        @XMLValue(name="Item")
        private List<Item> item;


        public static class Item {

            private static final String TAG = Item.class.getSimpleName();

            @XMLValue(name = "Text")
            private String title;
            @XMLValue(name = "Image")
            private Image image;
            @XMLValue(name = "Url")
            private String url;

            public static class Image {
                @XMLAttribute(name="source")
                private String source = "";



            }

        }

    }

}
