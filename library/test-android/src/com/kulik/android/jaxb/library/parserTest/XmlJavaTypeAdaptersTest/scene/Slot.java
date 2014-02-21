/*
 * Slot.java		Date created: May 24, 2013
 * Last modified by: kadygrob
 * $Revision$	May 24, 2013
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
