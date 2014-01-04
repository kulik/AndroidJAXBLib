package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 10:30 PM
 */
public class DateAdapter extends XmlAdapter<String, Date> {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        @Override
        public String marshal(Date v) throws Exception {
            return dateFormat.format(v);
        }

        @Override
        public Date unmarshal(String v) throws Exception {
            return dateFormat.parse(v.trim());
        }
    }
