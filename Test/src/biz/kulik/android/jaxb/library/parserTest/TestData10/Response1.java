package biz.kulik.android.jaxb.library.parserTest.TestData10;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Response1 {
    @XmlElement(name = "data")
    public List<BankResponse> mBankList;


    public static class BankResponse {
        @XmlElement(name = "bank")
        public String mName;

        @XmlElement(name = "email")
        public String mEmail;

        @XmlElement(name = "phone")
        public String mPhone;

        public BankResponse() {
        }

        public BankResponse(String name, String email, String phone) {
            mName = name;
            mEmail = email;
            mPhone = phone;
        }

        @Override
        public String toString() {
            return mName;
        }
    }
}
