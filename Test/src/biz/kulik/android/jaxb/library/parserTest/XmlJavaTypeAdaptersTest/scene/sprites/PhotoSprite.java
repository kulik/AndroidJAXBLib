package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;

public class PhotoSprite extends SceneObject {

    @XmlAttribute(name = "fileName")
    public String mFileName;


    @XmlAttribute(name = "slotNo")
    public int mSlotNo;

    public PhotoSprite() {
    }

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.PHOTO;
    }
}
