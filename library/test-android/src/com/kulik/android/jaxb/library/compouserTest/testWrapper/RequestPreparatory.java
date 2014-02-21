package com.kulik.android.jaxb.library.compouserTest.testWrapper;

/**
 * Created by kulik on 1/8/14.
 */
public class RequestPreparatory {

    public SoapRoot prepare(EWSRequest request) {
        SoapRoot root = new SoapRoot();
        root.body = request;
        return root;
    }

}
