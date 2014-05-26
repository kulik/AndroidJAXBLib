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
package com.kulik.android.jaxb.library.parserTest.TestData1;

import android.test.AndroidTestCase;
import android.test.PerformanceTestCase;
//import com.kulik.logger.EasyLoggerFactory;
//import com.kulik.logger.MyLog;


/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestPerformance extends AndroidTestCase implements PerformanceTestCase {
//    private static final MyLog LOG = EasyLoggerFactory.getLogger(TestPerformance.class);

    @Override
    protected void tearDown() throws Exception {
//        LOG.d("tearDown()");
        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
//        LOG.d("setUp()");
        super.setUp();
    }

    public void testPerfi() {
//        LOG.d("testPerfi()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int startPerformance(Intermediates intermediates) {
//        LOG.d("startPerformance()");
        intermediates.setInternalIterations(100);
        return 0;
    }

    @Override
    public boolean isPerformanceOnly() {
//        LOG.d("isPerformanceOnly()");
        return true;
    }
}
