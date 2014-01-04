package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;

/**
 * Determine static image sprite
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class StaticStamp extends SceneObject {

    @XmlAttribute(name = "fileName")
    private String fileName;

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.STATIC_STAMP;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
