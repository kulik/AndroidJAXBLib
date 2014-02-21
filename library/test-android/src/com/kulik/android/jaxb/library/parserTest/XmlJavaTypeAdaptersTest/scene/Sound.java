/*
 * Sound.java		Date created: May 24, 2013
 * Last modified by: kadygrob
 * $Revision$	May 24, 2013
 */

package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * This class determines sound files in a sprite
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class Sound {

    @XmlAttribute(name = "fileName")
    public String fileName;

}
