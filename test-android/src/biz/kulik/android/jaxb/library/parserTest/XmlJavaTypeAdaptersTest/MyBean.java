package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import biz.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapters;
import biz.kulik.android.jaxb.library.Annotations.XmlRootElement;

import java.util.Date;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 10:37 PM
 */
@XmlRootElement(name = "my_bean")
public class MyBean {
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "my_date")
    public Date myDate;
}
