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

