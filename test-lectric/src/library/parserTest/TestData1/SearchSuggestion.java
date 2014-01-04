package library.parserTest.TestData1;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class SearchSuggestion {

    @XmlElement(name="Section")
    public Section section;

    public static class Section {
        @XmlElement(name="Item")
        public List<Item> item;

        public static class Item {

            @XmlElement(name = "Text")
            public String title;
            @XmlElement(name = "Image")
            public Image image;
            @XmlElement(name = "Url")
            public String url;

            public static class Image {

                @XmlAttribute(name="source")
                public String source = "";
            }
        }
    }
}
