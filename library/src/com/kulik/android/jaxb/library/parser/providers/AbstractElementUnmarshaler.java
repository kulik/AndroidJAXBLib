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
package com.kulik.android.jaxb.library.parser.providers;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 10/25/12
 * Time: 11:39 AM
 */
public abstract class AbstractElementUnmarshaler implements ElementUnmarshaler {


    protected AbstractElementUnmarshaler(InputStream data) {
        init(data);
    }

    protected AbstractElementUnmarshaler(String data) {
        init(data);
    }

    public AbstractElementUnmarshaler() {
    }

    protected abstract void init(InputStream data);

    protected abstract void init(String data);

}
