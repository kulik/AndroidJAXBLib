package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * The class determines the sprites of the type "border"
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class Border extends SceneObject {

    @XmlAttribute(name = "fileName")
    public String fileName;

    @XmlAttribute(name = "widthPortion")
    public float borderWidth;

    @XmlAttribute(name = "heightPortion")
    public float borderHeight;

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.BORDER;
    }

}
