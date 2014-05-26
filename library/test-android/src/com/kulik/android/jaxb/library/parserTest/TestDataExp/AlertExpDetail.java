/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 15.02.13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class AlertExpDetail implements Serializable {

    @XmlElement(name = "ExpType")
    public String expType;

    @XmlElement(name = "Exptype_Descr")
    public String exptype_Descr;

    @XmlElement(name = "FieldName")
    public String fieldName;

    @XmlElement(name = "Fieldtype")
    public String fieldType;

    @XmlElement(name = "FieldValue")
    public String fieldValue;

    @XmlElement(name = "ExpTypeEdit")
    public String expTypeEdit;

    @XmlElement(name = "TaxImplFlg")
    public String taxImplFlg;

    @XmlElement(name = "SalesTax")
    public String salesTax;

    @XmlElement(name = "VATAmount")
    public String vatAmount;

}
