package library.parserTest.TestData1;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 11:46 AM
 */
public class Country {
    @XmlElement(name="Title")
    private String title;

    @XmlElement(name="City")
    private List<City> cities;

    public Country(){
        title="";
    }

    public static class City {
        @XmlElement(name="Title")
        private String title;

        @XmlElement(name="Description")
        private String description;

        public City(){
            title = "";
            description="";
        }
    }
}
