/*
 * SpriteInterface.java		Date created: May 27, 2013
 * Last modified by: kadygrob
 * $Revision$	May 27, 2013
 */

package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites;

import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;

/**
 * The interface must be implemented by the sprites for determining of the type every of them
 *
 * @author kadygrob Copyright QArea Inc, 2013
 * @return Returns a sprite's type.
 */
public abstract class SceneObject {


    public static enum SceneObjectType {

        PHOTO(false), DRAW(false), TEXT(false), GYRO(false), BORDER(false), STATIC_STAMP(false), ANIMATED_STAMP(false),
        SELECTOR(true);

        private final boolean mIsSupport;

        SceneObjectType(boolean isSupport) {
            mIsSupport = isSupport;
        }

        public static SceneObjectType getValueByName(String name) {
            return Enum.valueOf(SceneObjectType.class, name);
        }

        public boolean isSupport() {
            return mIsSupport;
        }
    }


    public Geometry geometry;

    public abstract SceneObjectType getType();


}
