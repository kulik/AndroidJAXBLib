package biz.mobidev.android.jaxb.library;

import android.util.Log;
import biz.mobidev.android.jaxb.library.Annotations.XMLValue;

import java.util.List;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 11:46 AM
 */
public class Country {
    private static final String TAG = Country.class.getSimpleName();
    @XMLValue(name="Title")
    private String title;
    @XMLValue(name="City")
    private List<City> cities;

    public Country(){
        Log.v(TAG,"Country constructor");
        title="";
    }

    public static class City {
        private static final String TAG = City.class.getSimpleName();
        @XMLValue(name="Title")
        private String title;
        @XMLValue(name="Description")
        private String description;

        public City(){
            Log.v(TAG,"City constructor");
            title = "";
            description="";
        }
    }
}
