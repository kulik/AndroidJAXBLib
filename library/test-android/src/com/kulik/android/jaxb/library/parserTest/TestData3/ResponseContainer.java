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
package com.kulik.android.jaxb.library.parserTest.TestData3;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 11/6/12
 * Time: 2:31 PM
 */
//@XmlRootElement(name = "response")
public class ResponseContainer<T extends AbstractResponse> {

    public static final String STATUS_SUCCESS = "success";

    public static final String STATUS_ERROR = "error";

    /**
     * Server operation success flag.
     */
    @XmlElement(name = "status")
    public String statusFlag;

    /**
     * There will be placed depend on statusFlag:<br/>
     * on success - returned data from server;<br/>
     * on error - null.<br/>
     */
    @XmlElement(name = "data")
    public T data;

    /**
     * There will be placed depend on statusFlag:<br/>
     * on success - null;<br/>
     * on error - server error descriptor.<br/>
     */
    @XmlElement(name = "error")
    public Object error;

}