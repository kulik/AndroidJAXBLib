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

/**
 * User: bender
 * Date: 26.12.12
 * Time: 17:49
 */
public abstract class AbstractWorkerResponse extends AbstractResponse {
    protected static final String FUNCTION_GET_EMAIL = "Worker_Email.v1/";
    protected static final String FUNCTION_SEND_PASSWORD = "Email_Pswd.v1/";
    protected static final String FUNCTION_GET_HOME_TAB = "WorkerHomeDetail.v1/";
    protected static final String FUNCTION_GET_ROSTER = "parserDima21.v1/";
    protected static final String FUNCTION_GET_TS_SAVED = "TS_Saved.v1/";
    protected static final String FUNCTION_GET_TS_HISTORY = "TimeSheetHistory.v1/";
    protected static final String FUNCTION_GET_ALERTS = "WorkerAlert.v1/";
    protected static final String FUNCTION_GET_EXP_HISTORY = "PRV_WORKER_EXP_HISTORY.v1/";
    protected static final String FUNCTION_GET_EXP_SAVED = "PRV_WORKER_SAVED.v1/";
    protected static final String FUNCTION_GET_EXP_SELECT = "PRV_WORKER_EXP_SELECT.v1/";
    protected static final String FUNCTION_GET_CONTACT_US = "ContactUs.v1/";

    protected static final String FUNCTION_POS_CREATE_TS_40 = "PRV_WORKER_TS_CREATE.v1/";
    protected static final String FUNCTION_POS_CREATE_TS_CLOCK = "TSCreate_Clock.v1/";

    @Override
    public String getLogin() {
//        if (WorkerApplication.getLogin() != null){
//            return WorkerApplication.getLogin();
//        } else {
//            return LocalPreferences.getLogin();
//        }
        return null;
    }

    @Override
    public String getPassword() {
        //return LocalPreferences.getPassword();
        return null;
    }


    @Override
    public AbstractResponse getErrorResponse() {
        return null;
    }

    @Override
    public AbstractResponse getBadRequestErrorResponse() {
        return null;
    }
}
