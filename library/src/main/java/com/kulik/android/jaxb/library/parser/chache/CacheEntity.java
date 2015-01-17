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
package com.kulik.android.jaxb.library.parser.chache;

import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 12/12/12
 * Time: 4:05 PM
 */
public class CacheEntity {

    private MethodFieldAdapter mMethodField;
    private String mXmlName;
    private String mXmlNS;

    public CacheEntity(MethodFieldAdapter mf, String xmlName, String ns) {
        mMethodField = mf;
        mXmlName = xmlName;
        mXmlNS = ns;
    }

    public String getXmlName() {
        return mXmlName;
    }

    public MethodFieldAdapter getMethodField() {
        return mMethodField;
    }

    public String getNS() {
        return mXmlNS;
    }
}
