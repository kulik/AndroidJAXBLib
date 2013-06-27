/*
 * AnimatedImageSprite.java		Date created: 21 ����. 2013
 * Last modified by: kadygrob
 * $Revision$	21 ����. 2013
 */

package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Frame;

import java.util.List;

/**
 * Manages the animation of the image sprites
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class AnimatedStamp extends SceneObject {

    @XmlAttribute(name = "fps")
    private int framesPerSecond;

    @XmlElementWrapper(name = "frames")
    @XmlElement(name = "frame")
    private List<Frame> frames;

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.ANIMATED_STAMP;
    }

}
