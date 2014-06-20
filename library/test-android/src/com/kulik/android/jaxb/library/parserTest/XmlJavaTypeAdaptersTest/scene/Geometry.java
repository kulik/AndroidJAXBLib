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
 * The class determines the geometry parameters of each sprite
 *
 * @author kadygrob Copyright QArea Inc, 2013
 */

public class Geometry {

    @XmlAttribute(name = "centerX")
    public float centerX;

    @XmlAttribute(name = "centerY")
    public float centerY;

    @XmlAttribute(name = "width")
    public float width;

    @XmlAttribute(name = "height")
    public float height;

    @XmlAttribute(name = "angle")
    public float angle;

    public Geometry() {
    }

    /**
     * Construct the geometric parametric of the scene.
     *
     * @param centerX
     * @param centerY
     * @param width
     * @param height
     * @param angle
     */
    public Geometry(float centerX, float centerY, float width, float height, float angle) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.angle = angle;
        //scaleFactor = 0.25f;
    }

}
