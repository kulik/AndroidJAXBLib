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
package com.kulik.android.jaxb.library.parserTest.TestData6;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;

/**
 * User: bender
 * Date: 26.12.12
 * Time: 17:25
 */
public class ParseCreateTSWeekResponse extends AbstractWorkerResponse implements Composed {

    private Serializable mComposed;

    public ParseCreateTSWeekResponse(Serializable composed) {
        mComposed = composed;
    }

    public ParseCreateTSWeekResponse() {
    }

    @XmlElement(name = "text")
    public String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public Class getResponseClass() {
        return ParseCreateTSWeekResponse.class;// GetEmailResponse.class;
    }

    @Override
    public String getFunction() {
        return FUNCTION_POS_CREATE_TS_40;
    }

    @Override
    public Serializable getComposerObject() {
        return mComposed;
    }
}
