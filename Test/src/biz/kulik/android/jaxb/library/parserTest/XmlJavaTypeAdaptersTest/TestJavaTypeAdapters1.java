package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest;

import biz.kulik.android.jaxb.library.ParserAbstractTest;
import biz.kulik.android.jaxb.library.R;
import biz.kulik.android.jaxb.library.parser.UnMarshalerTypes;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Scene;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.*;

import java.util.Date;

/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestJavaTypeAdapters1 extends ParserAbstractTest<Scene> {


    public void testParseJavaTypeAdaptersXML() {
        parse(UnMarshalerTypes.XMLAdapter, R.raw.scene, Scene.class);
    }


    @Override
    protected void assertTestData(Scene scene) {
        assertNotNull(scene);
        assertNotNull(scene.sceneObjects);
        assertEquals(scene.sceneObjects.size(), 7);
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
//
//        <sprite type="Stamp" stampType="animated">
//        <stampAnimated fps="10">
//        <frames>
//        <frame fileName="spriteStamp002_001.jpg"/>
//        <frame fileName="spriteStamp002_002.jpg"/>
//        <frame fileName="spriteStamp002_003.jpg"/>
//        <frame fileName="spriteStamp002_004.jpg"/>
//        <frame fileName="spriteStamp002_005.jpg"/>
//        <frame fileName="spriteStamp002_006.jpg"/>
//        <frame fileName="spriteStamp002_007.jpg"/>
//        <frame fileName="spriteStamp002_008.jpg"/>
//        <frame fileName="spriteStamp002_009.jpg"/>
//        <frame fileName="spriteStamp002_010.jpg"/>
//        </frames>
//        </stampAnimated>
//        <geometry centerX="700" centerY="350" width="300" height="200"/>
//        <sound fileName="sound_001.mp3"/>
//        </sprite>
//
//        <sprite type="Stamp" stampType="gyro">
//        <stampGyro startingFrame="spriteStamp003_001.jpg">
//        <frames direction="left">
//        <frame fileName="spriteStamp003_001.jpg"/>
//        <frame fileName="spriteStamp003_002.jpg"/>
//        <frame fileName="spriteStamp003_003.jpg"/>
//        <frame fileName="spriteStamp003_004.jpg"/>
//        </frames>
//        <frames direction="right">
//        <frame fileName="spriteStamp003_005.jpg"/>
//        <frame fileName="spriteStamp003_006.jpg"/>
//        <frame fileName="spriteStamp003_007.jpg"/>
//        <frame fileName="spriteStamp003_008.jpg"/>
//        </frames>
//        <frames direction="up">
//        <frame fileName="spriteStamp003_009.jpg"/>
//        <frame fileName="spriteStamp003_010.jpg"/>
//        <frame fileName="spriteStamp003_011.jpg"/>
//        <frame fileName="spriteStamp003_012.jpg"/>
//        </frames>
//        <frames direction="down">
//        <frame fileName="spriteStamp003_013.jpg"/>
//        <frame fileName="spriteStamp003_014.jpg"/>
//        <frame fileName="spriteStamp003_015.jpg"/>
//        <frame fileName="spriteStamp003_016.jpg"/>
//        </frames>
//        </stampGyro>
//        <geometry centerX="700" centerY="350" width="300" height="200"/>
//        </sprite>


        assertNotNull(scene.background );
        assertNotNull(scene.background.fileName );
        assertEquals(scene.background.fileName, "scene_background.png");
        assertNotNull(scene.background.type );
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
