package biz.mobidev.android.jaxb.library;

import ua.kharkov.borovyk.wiki_search.Annotations;

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
