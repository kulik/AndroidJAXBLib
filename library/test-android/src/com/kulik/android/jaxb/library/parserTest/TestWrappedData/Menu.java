package com.kulik.android.jaxb.library.parserTest.TestWrappedData;

import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

import java.util.List;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class Menu {

    @XmlElementWrapper(name = "CostomElemWrapper")
    @XmlElement(name = "Category")
    public Category category;

    @XmlElementWrapper(name = "StringElWrapper")
    @XmlElement(name = "StringElem")
    public String mMyString;

    @XmlElementWrapper(name = "Categories")
    @XmlElement(name="Category")
    public List<Category> categories;
}