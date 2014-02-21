package com.kulik.android.jaxb.library.parserTest.TestWrappedData;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 5/26/13
 * Time: 3:44 PM
 */
public class Category {

    @XmlAttribute(name = "id")
    public String mId;

    @XmlAttribute(name = "order")
    public Integer mOrdering;

    @XmlElement(name = "elementA")
    public String mEl;

}
