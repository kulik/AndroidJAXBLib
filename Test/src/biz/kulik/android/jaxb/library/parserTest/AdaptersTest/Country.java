package biz.kulik.android.jaxb.library.parserTest.AdaptersTest;

import android.util.Log;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 11/21/12
 * Time: 11:46 AM
 */
public class Country {
    private static final String TAG = Country.class.getSimpleName();
    @XmlElement(name="Title")
    private String title;
    @XmlElement(name="City")
    private List<City> cities;

    public Country(){
        Log.v(TAG,"Country constructor");
        title="";
    }

    public static class City {
        private static final String TAG = City.class.getSimpleName();
        @XmlElement(name="Title")
        private String title;
        @XmlElement(name="Description")
        private String description;

        public City(){
            Log.v(TAG,"City constructor");
            title = "";
            description="";
        }
    }
}
