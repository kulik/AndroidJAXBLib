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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bender
 * Date: 14.02.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class SelectCollection implements Serializable {

//    @XmlElement(name = "PRV_WRKR_SAVED_SELECT")
//    private PRV_WRKR_SAVED_SELECT prvWrkrSavedSelects;
//
//    public PRV_WRKR_SAVED_SELECT getPrvWrkrSavedSelects() {
//        return prvWrkrSavedSelects;
//    }
//
//    public void setPrvWrkrSavedSelects(PRV_WRKR_SAVED_SELECT prvWrkrSavedSelects) {
//        this.prvWrkrSavedSelects = prvWrkrSavedSelects;
//    }

    @XmlElement(name = "PRV_WRKR_SAVED_SLCT_DTL")
    public List<PRV_WRKR_SAVED_SLCT_DTL> prvWrkrSelectDtl;

}
