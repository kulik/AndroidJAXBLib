package com.kulik.android.jaxb.library.parserTest.TestData6;

import java.io.Serializable;

public abstract class AbstractResponse implements Serializable {

    static final String BASE_URL = "https://release-dev.provade.com/PSIGW/RESTListeningConnector/";
    private static final String EMAIL_ID = "User/";
    protected Status mStatus = Status.OK;

    public enum Status {
        OK, ERROR, NO_INET, SERVER_ERROR, BAD_REQUEST
    }


    public abstract Class getResponseClass();

    public abstract String getFunction();

    public abstract String getLogin();

    public abstract String getPassword();

    public abstract AbstractResponse getErrorResponse();

    public abstract AbstractResponse getBadRequestErrorResponse();
//    public abstract Status getStatus();


    protected String mPostData;

    public String getPostData() {
        return mPostData;
    }

    public void setPostData(String mPostData) {
        this.mPostData = mPostData;
    }

    public String getFunctionUrl() {
        return BASE_URL + getFunction() + EMAIL_ID + getLogin();
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public Status getStatus () {
        return mStatus;
    }
}
