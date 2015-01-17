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
