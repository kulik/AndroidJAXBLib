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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Frame;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters.DirectionAdapter;

import java.util.List;

/**
 * User: kulik
 * Date: 7/2/13
 * Time: 12:11 PM
 */
public class Frames {
    public static enum Direction {
        LEFT, RIGHT, UP, DOWN;

        public static Direction getByName(String name) {
            return valueOf(name.toUpperCase());
        }
    }

    @XmlJavaTypeAdapter(DirectionAdapter.class)
    @XmlAttribute(name = "direction")
    public Direction direction;

    @XmlElement(name = "frame")
    public List<Frame> frames;


}
