package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.Frames;

/**
 * User: kulik
 * Date: 7/2/13
 * Time: 12:16 PM
 */
public class DirectionAdapter extends XmlAdapter<String, Frames.Direction> {
    @Override
    public String marshal(Frames.Direction v) throws Exception {
        return v.name().toLowerCase();
    }

    @Override
    public Frames.Direction unmarshal(String v) throws Exception {
        return Frames.Direction.valueOf(v.toUpperCase());
    }
}

