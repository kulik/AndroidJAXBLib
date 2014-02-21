package com.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Response3 {
    @XmlElement(name = "data")
    public Settings mSettings;

    public static class Settings {
        @XmlElement(name = "phone")
        public String mCallUsPhone;
    }

}
