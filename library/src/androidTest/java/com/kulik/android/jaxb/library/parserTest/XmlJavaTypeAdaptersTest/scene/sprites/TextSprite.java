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
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;

/**
 * This class describes the text sprites
 *
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class TextSprite extends SceneObject {

    @XmlAttribute(name = "text")
    public String text;

    @XmlAttribute(name = "fontFamily")
    public String fontFamily;

    @XmlAttribute(name = "fontColor")
    public String fontColor;

    @XmlAttribute(name = "fontWeight")
    public String fontWeight;

    @XmlAttribute(name = "fontSize")
    public int fontSize;

    public TextSprite() {
    }

    public TextSprite(String t, Geometry g) {
        text = t;
        geometry = g;
    }

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.TEXT;
    }

}
