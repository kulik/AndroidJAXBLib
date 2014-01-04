package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Sound;

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
