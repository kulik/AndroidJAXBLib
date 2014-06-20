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
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Sound;

/**
 * Base class for a sprite
 *
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class SpriteAdapterBean {

    @XmlAttribute(name = "type")
    public String type;

    @XmlAttribute(name = "stampType")
    public String stampType;

    @XmlElement(name = "draw")
    public DrawSprite drawSprite;

    @XmlElement(name = "text")
    public TextSprite textSprite;

    @XmlElement(name = "photo")
    public PhotoSprite photoSprite;

    @XmlElement(name = "border")
    public Border borderStamp;

    @XmlElement(name = "stampStatic")
    public StaticStamp staticStamp;

    @XmlElement(name = "stampAnimated")
    public AnimatedStamp animatedStamp;

    @XmlElement(name = "stampGyro")
    public GyroStampSprite gyroStamp;

    @XmlElement(name = "geometry")
    public Geometry geometry;

    @XmlElement(name = "sound")
    public Sound sound;

}
