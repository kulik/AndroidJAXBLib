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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.Frames;

/**
 * User: kulik
 * Date: 7/2/13
 * Time: 12:16 PM
 */
public class DirectionAdapter extends XmlAdapter<String, Frames.Direction> {
    @Override
    public String marshal(Frames.Direction v) throws Exception {
        return v.name().toLowerCase();
    }

    @Override
    public Frames.Direction unmarshal(String v) throws Exception {
        return Frames.Direction.valueOf(v.toUpperCase());
    }
}

