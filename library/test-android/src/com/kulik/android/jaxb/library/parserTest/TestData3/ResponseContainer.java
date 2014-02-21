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