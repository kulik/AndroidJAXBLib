/*
 * SceneBackground.java		Date created: 21 ����. 2013
 * Last modified by: kadygrob
 * $Revision$	21 ����. 2013
 */

package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * Describe a background for a scene
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class SceneBackground {

    @XmlAttribute(name = "fileName")
    public String fileName;

    @XmlAttribute(name = "type")
    public String type;

}
