package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * This class describes the render sprites
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class DrawSprite extends SceneObject {

    @XmlAttribute(name = "fileName")
    public String fileName;

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.DRAW;
    }

}
