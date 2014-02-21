/*
 * Geometry.java		Date created: May 24, 2013
 * Last modified by: kadygrob
 * $Revision$	May 24, 2013
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
