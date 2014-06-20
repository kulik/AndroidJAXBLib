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
package com.kulik.android.jaxb.library;

import android.test.AndroidTestCase;

import com.kulik.android.jaxb.library.parser.Parser;
import com.kulik.android.jaxb.library.parser.ParserImpl;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:45 PM
 */
public abstract class ParserAbstractTest<T> extends AndroidTestCase {
    private static final String TAG = ParserAbstractTest.class.getSimpleName();
    private Parser mParser;

    protected void parse(UnMarshalerTypes type, int resID, Class<T> clazz) throws Exception {
        init(type);
        parseInternal(resID, clazz);
    }

    protected void init(UnMarshalerTypes type) throws Exception {
        mParser = new ParserImpl(type);
    }

    protected void parseInternal(int resID, Class<T> clazz) throws Exception {
        InputStream inputStream = getContext().getResources().openRawResource(resID);
        T ts = mParser.parse(clazz, inputStream);
        assertTestData(ts);
    }

    protected abstract void assertTestData(T ts);

}
