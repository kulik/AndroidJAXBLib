package biz.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Response2 {
    public static class Response {
        @XmlElement(name = "data")
        SearchSettingsResponse mSearchSettings;
    }

    public static class SearchSettingsResponse {
        @XmlElement(name = "minPrices")
        public List<ValueInt> priceMinList;

        @XmlElement(name = "maxPrices")
        public List<ValueInt> priceMaxList;

        @XmlElement(name = "minRoomSizes")
        public List<ValueInt> squareMinList;

        @XmlElement(name = "maxRoomSizes")
        public List<ValueInt> squareMaxList;

        @XmlElement(name = "minBedrooms")
        public List<ValueInt> bedroomMinList;

        @XmlElement(name = "propertyType")
        public List<ValueInt> apartmentTypeList;

        @XmlElement(name = "categorySearch")
        public List<Category> categoryList;
    }

    public static class ValueInt implements Value<Integer> {
        @XmlElement(name = "value")
        private final Integer mValue;

        @XmlElement(name = "showas")
        private final String mShowAs;

        public ValueInt() {
            this(0, "");
        }

        public ValueInt(int value, String showAs) {
            mValue = value;
            mShowAs = showAs;
        }

        @Override
        public Integer getValue() {
            return mValue;
        }

        @Override
        public String getName() {
            return mShowAs;
        }

    }

    public class Category implements Value<String> {
        @XmlElement(name = "value")
        private final String mValue;

        @XmlElement(name = "showas")
        private String mShowAs;

        public Category() {
            mValue = "";
            mShowAs = "";
        }

        @Override
        public String getValue() {
            return mValue;
        }

        @Override
        public String getName() {
            return mShowAs;
        }

        public void setName(String name) {
            mShowAs = name;
        }
    }

}
