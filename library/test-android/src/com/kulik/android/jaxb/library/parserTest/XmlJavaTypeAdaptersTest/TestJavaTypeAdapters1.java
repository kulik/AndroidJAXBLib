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
package com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import com.kulik.android.jaxb.library.ParserAbstractTest;
import com.kulik.android.jaxb.library.R;
import com.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Scene;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.AnimatedStamp;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.Border;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.DrawSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.Frames;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.GyroStampSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.PhotoSprite;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.StaticStamp;
import com.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.TextSprite;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters1 extends ParserAbstractTest<Scene> {


    public void testParseJavaTypeAdaptersXML() throws Exception {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.scene, Scene.class);
    }


    @Override
    protected void assertTestData(Scene scene) {
        assertNotNull(scene);
        assertNotNull(scene.sceneObjects);
        assertEquals(scene.sceneObjects.size(), 8);
        int i = 0;
        assertTrue(scene.sceneObjects.get(i) instanceof PhotoSprite);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.PHOTO);
        assertEquals(((PhotoSprite) scene.sceneObjects.get(i)).mFileName, "sprite_001.jpg");
        assertEquals(((PhotoSprite) scene.sceneObjects.get(i)).mSlotNo, -1);
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 110f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 120f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 200f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 100f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 10f);
        i = 1;
        assertTrue(scene.sceneObjects.get(i) instanceof DrawSprite);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.DRAW);
        assertEquals(((DrawSprite) scene.sceneObjects.get(1)).fileName, "sprite_002.jpg");
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 500f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 400f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 350f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 250f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 30f);
        i = 2;
        assertTrue(scene.sceneObjects.get(i) instanceof TextSprite);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.TEXT);
        assertEquals(((TextSprite) scene.sceneObjects.get(i)).fontFamily, "Helvetica");
        assertEquals(((TextSprite) scene.sceneObjects.get(i)).fontColor, "#335577");
        assertEquals(((TextSprite) scene.sceneObjects.get(i)).fontSize, 10);
        assertEquals(((TextSprite) scene.sceneObjects.get(i)).text, "This is some text");
        assertEquals(((TextSprite) scene.sceneObjects.get(i)).fontWeight, "bold");
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 500f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 400f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 350f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 250f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 30f);
        i = 3;
        assertTrue(scene.sceneObjects.get(i) instanceof PhotoSprite);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.PHOTO);
        assertEquals(((PhotoSprite) scene.sceneObjects.get(i)).mFileName, "sprite_003.jpg");
        assertEquals(((PhotoSprite) scene.sceneObjects.get(i)).mSlotNo, -1);
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 700f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 350f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 300f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 200f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 60f);
        i = 4;
        assertTrue(scene.sceneObjects.get(i) instanceof Border);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.BORDER);
        assertEquals(((Border) scene.sceneObjects.get(i)).fileName, "sprite_004.jpg");
        assertEquals(((Border) scene.sceneObjects.get(i)).borderWidth, .1f);
        assertEquals(((Border) scene.sceneObjects.get(i)).borderHeight, 0.05f);
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 110f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 120f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 200f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 100f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 10f);
        i = 5;
        assertTrue(scene.sceneObjects.get(i) instanceof StaticStamp);
        assertEquals(scene.sceneObjects.get(i).getType(), SceneObject.SceneObjectType.STATIC_STAMP);
        assertEquals(((StaticStamp) scene.sceneObjects.get(i)).getFileName(), "spriteStamp001_001.jpg");
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 700f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 350f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 300f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 200f);
        assertEquals(scene.sceneObjects.get(i).geometry.angle, 60f);

        i = 6;
        assertTrue(scene.sceneObjects.get(i) instanceof AnimatedStamp);
        AnimatedStamp so6 = (AnimatedStamp) scene.sceneObjects.get(i);
        assertEquals(so6.getType(), SceneObject.SceneObjectType.ANIMATED_STAMP);
        assertEquals(so6.framesPerSecond, 10);
        assertNotNull(so6.frames);
        assertEquals(so6.frames.size(), 10);
        assertEquals(so6.frames.get(0).fileName, "spriteStamp002_001.jpg");
        assertEquals(so6.frames.get(1).fileName, "spriteStamp002_002.jpg");
        assertEquals(so6.frames.get(2).fileName, "spriteStamp002_003.jpg");
        assertEquals(so6.frames.get(3).fileName, "spriteStamp002_004.jpg");
        assertEquals(so6.frames.get(4).fileName, "spriteStamp002_005.jpg");
        assertEquals(so6.frames.get(5).fileName, "spriteStamp002_006.jpg");
        assertEquals(so6.frames.get(6).fileName, "spriteStamp002_007.jpg");
        assertEquals(so6.frames.get(7).fileName, "spriteStamp002_008.jpg");
        assertEquals(so6.frames.get(8).fileName, "spriteStamp002_009.jpg");
        assertEquals(so6.frames.get(9).fileName, "spriteStamp002_010.jpg");
        assertNotNull(scene.sceneObjects.get(i).geometry);
        assertEquals(scene.sceneObjects.get(i).geometry.centerX, 700f);
        assertEquals(scene.sceneObjects.get(i).geometry.centerY, 350f);
        assertEquals(scene.sceneObjects.get(i).geometry.width, 300f);
        assertEquals(scene.sceneObjects.get(i).geometry.height, 200f);
        assertEquals(so6.soundFilePath, "sound_001.mp3");

        i = 7;
        assertTrue(scene.sceneObjects.get(i) instanceof GyroStampSprite);
        GyroStampSprite so7 = (GyroStampSprite) scene.sceneObjects.get(i);
        assertEquals(so7.getType(), SceneObject.SceneObjectType.GYRO);
        assertNotNull(so7.framesSetList);
        assertEquals(so7.framesSetList.size(), 4);
        assertEquals(so7.framesSetList.get(0).direction, Frames.Direction.LEFT);
        assertEquals(so7.framesSetList.get(0).frames.size(), 4);
        assertEquals(so7.framesSetList.get(0).frames.get(0).fileName, "spriteStamp003_001.jpg");
        assertEquals(so7.framesSetList.get(0).frames.get(1).fileName, "spriteStamp003_002.jpg");
        assertEquals(so7.framesSetList.get(0).frames.get(2).fileName, "spriteStamp003_003.jpg");
        assertEquals(so7.framesSetList.get(0).frames.get(3).fileName, "spriteStamp003_004.jpg");
        assertEquals(so7.framesSetList.get(1).direction, Frames.Direction.RIGHT);
        assertEquals(so7.framesSetList.get(1).frames.size(), 4);
        assertEquals(so7.framesSetList.get(1).frames.get(0).fileName, "spriteStamp003_005.jpg");
        assertEquals(so7.framesSetList.get(1).frames.get(1).fileName, "spriteStamp003_006.jpg");
        assertEquals(so7.framesSetList.get(1).frames.get(2).fileName, "spriteStamp003_007.jpg");
        assertEquals(so7.framesSetList.get(1).frames.get(3).fileName, "spriteStamp003_008.jpg");
        assertEquals(so7.framesSetList.get(2).direction, Frames.Direction.UP);
        assertEquals(so7.framesSetList.get(2).frames.size(), 4);
        assertEquals(so7.framesSetList.get(2).frames.get(0).fileName, "spriteStamp003_009.jpg");
        assertEquals(so7.framesSetList.get(2).frames.get(1).fileName, "spriteStamp003_010.jpg");
        assertEquals(so7.framesSetList.get(2).frames.get(2).fileName, "spriteStamp003_011.jpg");
        assertEquals(so7.framesSetList.get(2).frames.get(3).fileName, "spriteStamp003_012.jpg");
        assertEquals(so7.framesSetList.get(3).direction, Frames.Direction.DOWN);
        assertEquals(so7.framesSetList.get(3).frames.size(), 4);
        assertEquals(so7.framesSetList.get(3).frames.get(0).fileName, "spriteStamp003_013.jpg");
        assertEquals(so7.framesSetList.get(3).frames.get(1).fileName, "spriteStamp003_014.jpg");
        assertEquals(so7.framesSetList.get(3).frames.get(2).fileName, "spriteStamp003_015.jpg");
        assertEquals(so7.framesSetList.get(3).frames.get(3).fileName, "spriteStamp003_016.jpg");
        assertNotNull(so7.geometry);
        assertEquals(so7.geometry.centerX, 700f);
        assertEquals(so7.geometry.centerY, 350f);
        assertEquals(so7.geometry.width, 300f);
        assertEquals(so7.geometry.height, 200f);

        assertNotNull(scene.background);
        assertNotNull(scene.background.fileName);
        assertEquals(scene.background.fileName, "scene_background.png");
        assertNotNull(scene.background.type);
        assertEquals(scene.background.type, "stretch");
        assertNotNull(scene.collage);
        assertNotNull(scene.collage.bgFileName);
        assertEquals(scene.collage.bgFileName, "collage_back.jpg");
        assertNotNull(scene.collage.slots);
        assertEquals(scene.collage.slots.size(), 4);
        assertEquals(scene.collage.slots.get(0).left, 5);
        assertEquals(scene.collage.slots.get(0).top, 5);
        assertEquals(scene.collage.slots.get(0).width, 40);
        assertEquals(scene.collage.slots.get(0).height, 40);
        assertEquals(scene.collage.slots.get(0).angle, 0);

        assertEquals(scene.collage.slots.get(1).left, 55);
        assertEquals(scene.collage.slots.get(1).top, 5);
        assertEquals(scene.collage.slots.get(1).width, 40);
        assertEquals(scene.collage.slots.get(1).height, 40);
        assertEquals(scene.collage.slots.get(1).angle, 0);

        assertEquals(scene.collage.slots.get(2).left, 5);
        assertEquals(scene.collage.slots.get(2).top, 55);
        assertEquals(scene.collage.slots.get(2).width, 40);
        assertEquals(scene.collage.slots.get(2).height, 40);
        assertEquals(scene.collage.slots.get(2).angle, 0);

        assertEquals(scene.collage.slots.get(3).left, 55);
        assertEquals(scene.collage.slots.get(3).top, 55);
        assertEquals(scene.collage.slots.get(3).width, 30);
        assertEquals(scene.collage.slots.get(3).height, 30);
        assertEquals(scene.collage.slots.get(3).angle, 20);

    }
}
