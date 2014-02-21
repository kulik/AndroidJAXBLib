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
