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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * The class determine the attributes of a slot in a collage
 *
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class Slot {

    @XmlAttribute(name = "left")
    public int left;

    @XmlAttribute(name = "top")
    public int top;

    @XmlAttribute(name = "width")
    public int width;

    @XmlAttribute(name = "height")
    public int height;

    @XmlAttribute(name = "angle")
    public int angle;


}
