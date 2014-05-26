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
package com.kulik.android.jaxb.library.parserTest.TestData_asynchrone;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public class TestParser10_1 extends ParserAbstractTest<Response1> {
    //TODO implement asynchronus test
    public void testParse10JSON() throws Exception {
        parse(UnMarshalerTypes.JSONAdapter, R.raw.test_10_1_json, Response1.class);
    }

    @Override
    protected void assertTestData(Response1 ts) {
        assertNotNull(ts);
        assertNotNull(ts.mBankList);
//        assertTrue(ts.mBankList.size() == 4);
    }
}
