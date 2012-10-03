package ua.kharkov.borovyk.wiki_search;

import android.util.Log;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
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
