package biz.kulik.android.jaxb.library.parserTest.TestLongData4;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class SearchSuggestion {
    private static final String TAG = SearchSuggestion.class.getSimpleName();

    @XmlElement(name="Section")
    private Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public static class Section {
        private static final String TAG = Section.class.getSimpleName();
        @XmlElement(name="Item")
        private List<Item> item;

        public List<Item> getItem() {
            return item;
        }


        public static class Item {

            private static final String TAG = Item.class.getSimpleName();

            @XmlElement(name = "Text")
            private String title;
            @XmlElement(name = "Image")
            private Image image;
            @XmlElement(name = "Url")
            private String url;

            public String getTitle() {
                return title;
            }

            public Image getImage() {
                return image;
            }

            public String getUrl() {
                return url;
            }

            public static class Image {

                @XmlAttribute(name="source")
                private String source = "";


                public String getSource() {
                    return source;
                }
            }

        }

    }

}
