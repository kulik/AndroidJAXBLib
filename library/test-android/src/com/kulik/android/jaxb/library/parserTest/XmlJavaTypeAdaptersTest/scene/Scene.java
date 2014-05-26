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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene;

import com.kulik.android.jaxb.library.Annotations.XmlElement;
import com.kulik.android.jaxb.library.Annotations.XmlElementWrapper;
import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import com.kulik.android.jaxb.library.Annotations.XmlRootElement;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.adapters.SpritesAdapter;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for a scene
 * <p/>
 * // * @param sprites The array must not include background and will be include the
 * // *                only one render sprite
 *
 * @author kadygrob Copyright QArea Inc, 2013
 */

@XmlJavaTypeAdapter(SpritesAdapter.class)
@XmlRootElement(name = "scene")
public class Scene {

    @XmlElement(name = "background")
    public SceneBackground background;

    @XmlElementWrapper(name = "sprites")
    @XmlElement(name = "sprite")
    public List<SceneObject> sceneObjects;

    @XmlElement(name = "collage")
    public Collage collage;

    @XmlElement(name = "scene_width")
    public int width;

    @XmlElement(name = "scene_height")
    public int height;

    public Scene() {
        sceneObjects = new ArrayList<SceneObject>();
    }
}

