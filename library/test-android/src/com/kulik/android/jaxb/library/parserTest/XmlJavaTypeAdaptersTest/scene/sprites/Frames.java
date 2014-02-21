package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Frame;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters.DirectionAdapter;

import java.util.List;

/**
 * User: kulik
 * Date: 7/2/13
 * Time: 12:11 PM
 */
public class Frames {
    public static enum Direction {
        LEFT, RIGHT, UP, DOWN;

        public static Direction getByName(String name) {
            return valueOf(name.toUpperCase());
        }
    }

    @XmlJavaTypeAdapter(DirectionAdapter.class)
    @XmlAttribute(name = "direction")
    public Direction direction;

    @XmlElement(name = "frame")
    public List<Frame> frames;


}
