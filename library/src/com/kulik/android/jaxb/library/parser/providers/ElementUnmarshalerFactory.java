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

import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;

import java.io.InputStream;

/**
 * User: kulik
 * Date: 27/11/12
 * Time: 70:52 AM
 */
public class ElementUnmarshalerFactory {

    public static ElementUnmarshaler createAdapter(UnMarshalerTypes ad, InputStream data) {
        ElementUnmarshaler unmarshaler = null;
        switch (ad) {
            case XMLAdapter:
                unmarshaler = new ElemXMLUnmarshalerImpl(data);
                break;
            case JSONAdapter:
                unmarshaler = new ElemJSONUnmarshalerImpl(data);
                break;
            case SOAPAdapter:
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry");
            }

        }
        return unmarshaler;
    }

    public static ElementUnmarshaler createAdapter(UnMarshalerTypes ad, String data) {
        ElementUnmarshaler unmarshaler = null;
        switch (ad) {
            case XMLAdapter:
                unmarshaler = new ElemXMLUnmarshalerImpl(data);
                break;
            case JSONAdapter:
                unmarshaler = new ElemJSONUnmarshalerImpl(data);
                break;
            case SOAPAdapter:
                //unmarshaler = new Ksoapaa();
                break;
            default: {
                throw new IllegalArgumentException("Adapter is not inplemented yet. Sorry");
            }

        }
        return unmarshaler;
    }
}
