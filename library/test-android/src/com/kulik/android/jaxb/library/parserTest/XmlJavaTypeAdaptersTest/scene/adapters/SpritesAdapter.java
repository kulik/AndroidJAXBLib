/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters;

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.AnimatedStamp;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.Border;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.DrawSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.GyroStampSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.PhotoSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SpriteAdapterBean;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.StaticStamp;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.TextSprite;

/**
 * User: kulik
 * Date: 6/10/13
 * Time: 4:35 PM
 */
public class SpritesAdapter extends XmlAdapter<SpriteAdapterBean, SceneObject> {

    @Override
    public SceneObject unmarshal(SpriteAdapterBean adapterBean) throws Exception {
        SceneObject.SceneObjectType type;
        if (adapterBean.stampType == null || adapterBean.stampType.equals("")) { // non animated
            type = SceneObject.SceneObjectType.getValueByName(adapterBean.type.toUpperCase());
        } else if ("animated".equals(adapterBean.stampType) && "Stamp".equals(adapterBean.type)) {
            type = SceneObject.SceneObjectType.ANIMATED_STAMP;
        } else if ("static".equals(adapterBean.stampType) && "Stamp".equals(adapterBean.type)) {
            type = SceneObject.SceneObjectType.STATIC_STAMP;
        } else if ("gyro".equals(adapterBean.stampType) && "Stamp".equals(adapterBean.type)) {
            type = SceneObject.SceneObjectType.GYRO;
        } else {
            throw new IllegalArgumentException("No Sprite type found for type: " + adapterBean.type);
        }

        SceneObject so = null;
        switch (type) {
            case STATIC_STAMP:
                so = adapterBean.staticStamp;
                break;
            case ANIMATED_STAMP:
                so = adapterBean.animatedStamp;
                adapterBean.animatedStamp.soundFilePath = adapterBean.sound.fileName;
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

        if (v instanceof StaticStamp) {
            adapterBean.staticStamp = (StaticStamp) v;
            adapterBean.type = "Stamp";
            adapterBean.stampType = "Static";
        } else if (v instanceof AnimatedStamp) {
            adapterBean.animatedStamp = (AnimatedStamp) v;
            adapterBean.type = "Stamp";
            adapterBean.stampType = "Animated";
        } else if (v instanceof Border) {
            adapterBean.borderStamp = (Border) v;
            adapterBean.type = "Border";
        } else if (v instanceof DrawSprite) {
            adapterBean.drawSprite = (DrawSprite) v;
            adapterBean.type = "Draw";
        } else if (v instanceof GyroStampSprite) {
            adapterBean.gyroStamp = (GyroStampSprite) v;
            adapterBean.type = "Gyro";
        } else if (v instanceof PhotoSprite) {
            adapterBean.photoSprite = (PhotoSprite) v;
            adapterBean.type = "Photo";
        } else if (v instanceof TextSprite) {
            adapterBean.textSprite = (TextSprite) v;
            adapterBean.type = "Text";
        } else {
            throw new IllegalArgumentException("Unsupported Sprite type: " + v);
        }
        adapterBean.geometry = v.geometry;
        return adapterBean;
    }

}

