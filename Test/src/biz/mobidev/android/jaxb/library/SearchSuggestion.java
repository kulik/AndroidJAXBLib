package biz.mobidev.android.jaxb.library;

import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class SearchSuggestion {
    private static final String TAG = SearchSuggestion.class.getSimpleName();

    @Annotations.Value(name="Section")
    private Section section;

    public Section getQuery() {
        return section;
    }

    public void setQuery(Section query) {
        this.section = query;
    }

    public static class Section {
        private static final String TAG = Section.class.getSimpleName();
        @Annotations.Value(name="Item")
        private List<Item> item;


        public static class Item {

            private static final String TAG = Item.class.getSimpleName();

            @Annotations.Value(name = "Text")
            private String title;
            @Annotations.Value(name = "Image")
            private Image image;
            @Annotations.Value(name = "Url")
            private String url;

            public static class Image {
                @Annotations.Attribute(name="source")
                private String source = "";



            }

        }

    }

}
