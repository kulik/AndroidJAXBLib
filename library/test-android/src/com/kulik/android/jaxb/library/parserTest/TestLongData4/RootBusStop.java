package com.kulik.android.jaxb.library.parserTest.TestLongData4;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:58 PM
 */
public class RootBusStop {
    @XmlElement(name = "root")
    List<BusStops> mBusStops;

    public static class BusStops {
        private static final String TAG = BusStops.class.getSimpleName();

        @XmlElement(name = "bus_stop_id")
        private String mBusID;

        @XmlElement(name = "id")
        private Integer mID;

        @XmlElement(name = "full_name")
        private String mFullName;

        @XmlElement(name = "short_name")
        private String mShortName;

        @XmlElement(name = "naptan_code")
        private String mNapTanCode;

        @XmlElement(name = "latitude")
        private Double mLat;

        @XmlElement(name = "longitude")
        private Double mLong;

        @XmlElement(name = "road")
        private String mRoad;

        @XmlElement(name = "suburb")
        private String mSuburb;

        @XmlElement(name = "town_name")
        private String mTownName;

        @XmlElement(name = "city")
        private String mCity;

        @XmlElement(name = "county")
        private String mCounty;

        @XmlElement(name = "postcode")
        private String mPostCode;

        @XmlElement(name = "state_district")
        private String mStateDistrict;

        @XmlElement(name = "country")
        private String mCountry;

        @XmlElement(name = "last_modified_time")
        private String mLastModifiedTime;

        @XmlElement(name = "bus_registration_status")
        private String mBusRegistrationStatus;

        @XmlElement(name = "bus_stop_type")
        private String mBusStopType;

        @XmlElement(name = "stop_type")
        private String mStopType;

        @XmlElement(name = "grand_parent_locality")
        private String mParentLocalityl;

        @XmlElement(name = "grid_type")
        private String mGridType;

        @XmlElement(name = "identifier")
        private String mIdentifier;

        @XmlElement(name = "landmark")
        private String mLandMark;

        @XmlElement(name = "locality_centre")
        private String LocalityCenter;

        @XmlElement(name = "nat_gaz_id")
        private String mNatGazID;

        @XmlElement(name = "nat_gaz_locality")
        private String mNatGazLocality;

        @XmlElement(name = "parent_locality")
        private String mParentLocality;

        @XmlElement(name = "atco_code")
        private String mAtcoCode;

        @XmlElement(name = "naptan_street")
        private String mNaptanStreet;

        @XmlElement(name = "naptan_suburb")
        private String mNapTanSubURB;

        @XmlElement(name = "naptan_town")
        private String mNapTanTown;

        @XmlElement(name = "naptan_common_name")
        private String mNapTanCommonName;

        @XmlElement(name = "naptan_direction")
        private String mNapTanDirrection;
    }
}