package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import biz.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.*;

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
        SpriteAdapterBean adapterBean = new SpriteAdapterBean();
        SceneObject so = null;
        if (v instanceof StaticStamp) {
            adapterBean.staticStamp = (StaticStamp) v;
            adapterBean.type = SceneObject.SceneObjectType.STATIC_STAMP;
        } else if (v instanceof AnimatedStamp) {
            adapterBean.animatedStamp = (AnimatedStamp) v;
            adapterBean.type = SceneObject.SceneObjectType.ANIMATED_STAMP;
        } else if (v instanceof Border) {
            adapterBean.borderStamp = (Border) v;
            adapterBean.type = SceneObject.SceneObjectType.BORDER;
        } else if (v instanceof DrawSprite) {
            adapterBean.drawSprite = (DrawSprite) v;
            adapterBean.type = SceneObject.SceneObjectType.DRAW;
        } else if (v instanceof GyroStampSprite) {
            adapterBean.gyroStamp = (GyroStampSprite) v;
            adapterBean.type = SceneObject.SceneObjectType.GYRO;
        } else if (v instanceof PhotoSprite) {
            adapterBean.photoSprite = (PhotoSprite) v;
            adapterBean.type = SceneObject.SceneObjectType.PHOTO;
        } else if (v instanceof TextSprite) {
            adapterBean.textSprite = (TextSprite) v;
            adapterBean.type = SceneObject.SceneObjectType.TEXT;
        } else {
                throw new IllegalArgumentException("Unsupported Sprite type: " + v);
        }
            adapterBean.geometry = v.geometry;
        return adapterBean;
    }
}
