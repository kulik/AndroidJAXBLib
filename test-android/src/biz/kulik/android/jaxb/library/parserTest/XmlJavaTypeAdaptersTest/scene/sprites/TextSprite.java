package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import android.graphics.Color;
import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;

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
