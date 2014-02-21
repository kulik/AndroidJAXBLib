package com.kulik.android.jaxb.library;

import android.app.Application;

import com.kulik.android.jaxb.library.loger.Log;
//import com.kulik.logger.EasyLoggerFactory;
//import com.kulik.logger.MyLogAndroid;

/**
 * User: kulik
 * Date: 4/19/13
 * Time: 5:46 PM
 */
public class TestApplication extends Application {

    public TestApplication() {
        super();
        Log.setLogLevel(Log.Level.INFO);
    }
}
