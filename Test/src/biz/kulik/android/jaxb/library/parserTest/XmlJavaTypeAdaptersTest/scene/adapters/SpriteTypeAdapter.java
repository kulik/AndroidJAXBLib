package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SpriteAdapterBean;

/**
 * User: kulik
 * Date: 6/10/13
 * Time: 4:35 PM
 */
public class SpriteTypeAdapter extends XmlAdapter<SpriteAdapterBean, SceneObject>{

    @Override
    public SceneObject unmarshal(SpriteAdapterBean adapterBean) throws Exception {
        switch (adapterBean.type) {
            case STATIC_STAMP:
                return adapterBean.staticStamp;
            case ANIMATED_STAMP:
                return adapterBean.animatedStamp;
            case BORDER:
                return adapterBean.borderStamp;
            case DRAW:
                return adapterBean.drawSprite;
            case GYRO:
                return adapterBean.gyroStamp;
            case PHOTO:
                return adapterBean.photoSprite;
            case TEXT:
                return adapterBean.textSprite;
            default:
                throw new IllegalArgumentException("Unsupported Sprite type: " + adapterBean.type);
        }

    }

    @Override
    public SpriteAdapterBean marshal(SceneObject v) throws Exception {
        return null;
    }
}
