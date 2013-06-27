package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SpriteAdapterBean;

/**
 * User: kulik
 * Date: 6/10/13
 * Time: 4:35 PM
 */
public class SpritesAdapter extends XmlAdapter<SpriteAdapterBean, SceneObject>{

    @Override
    public SceneObject unmarshal(SpriteAdapterBean adapterBean) throws Exception {
        SceneObject so = null;
        switch (adapterBean.type) {
            case STATIC_STAMP:
                so = adapterBean.staticStamp;
                break;
            case ANIMATED_STAMP:
                so = adapterBean.animatedStamp;
                break;
            case BORDER:
                so = adapterBean.borderStamp;
                break;
            case DRAW:
                so = adapterBean.drawSprite;
                break;
            case GYRO:
                so = adapterBean.gyroStamp;
                break;
            case PHOTO:
                so = adapterBean.photoSprite;
                break;
            case TEXT:
                so = adapterBean.textSprite;
                break;
            default:
                throw new IllegalArgumentException("Unsupported Sprite type: " + adapterBean.type);
        }
        so.geometry = adapterBean.geometry;
        return so;

    }

    @Override
    public SpriteAdapterBean marshal(SceneObject v) throws Exception {
        return null;
    }
}
