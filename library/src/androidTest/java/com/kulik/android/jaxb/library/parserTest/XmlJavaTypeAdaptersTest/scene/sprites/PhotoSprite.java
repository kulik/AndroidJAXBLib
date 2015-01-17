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

import com.kulik.android.jaxb.library.Annotations.XmlAttribute;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;

public class PhotoSprite extends SceneObject {

    @XmlAttribute(name = "fileName")
    public String mFileName;


    @XmlAttribute(name = "slotNo")
    public int mSlotNo;

    public PhotoSprite() {
    }

    @Override
    public SceneObjectType getType() {
        return SceneObjectType.PHOTO;
    }

    public PhotoSprite(String fileName, Integer slotNo, Geometry geometry) {
        this.mFileName = fileName;
        this.mSlotNo = slotNo;
        this.geometry = geometry;
    }
}
