package biz.mobidev.android.jaxb.library;

import android.util.Log;

import java.util.List;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 11:46 AM
 */
public class Country {
    private static final String TAG = Country.class.getSimpleName();
    @Annotations.Value(name="Title")
    private String title;
    @Annotations.Value(name="City")
    private List<City> cities;

    public Country(){
        Log.v(TAG,"Country constructor");
        title="";
    }

    public static class City {
        private static final String TAG = City.class.getSimpleName();
        @Annotations.Value(name="Title")
        private String title;
        @Annotations.Value(name="Description")
        private String description;

        public City(){
            Log.v(TAG,"City constructor");
            title = "";
            description="";
        }
    }
}
