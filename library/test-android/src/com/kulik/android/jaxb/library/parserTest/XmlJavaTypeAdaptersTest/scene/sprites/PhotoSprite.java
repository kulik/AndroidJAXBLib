package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;

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

    public PhotoSprite(String fileName, Integer slotNo, Geometry geometry) {
        this.mFileName = fileName;
        this.mSlotNo = slotNo;
        this.geometry = geometry;
    }
}
