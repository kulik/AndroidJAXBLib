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

    public Status getStatus() {
        return mStatus;
    }
}
