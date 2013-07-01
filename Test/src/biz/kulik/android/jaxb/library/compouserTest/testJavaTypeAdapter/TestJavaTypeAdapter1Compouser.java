package biz.kulik.android.jaxb.library.compouserTest.testJavaTypeAdapter;

import android.test.AndroidTestCase;
import android.util.Log;
import biz.kulik.android.jaxb.library.DocUtils;
import biz.kulik.android.jaxb.library.adapters.AdapterException;
import biz.kulik.android.jaxb.library.composer.Composer;
import biz.kulik.android.jaxb.library.composer.ComposerImpl;
import biz.kulik.android.jaxb.library.composer.providers.ProviderTypes;
import biz.kulik.android.jaxb.library.composer.providers.abstractProvider.UMO;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.MyBean;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Geometry;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.Scene;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.PhotoSprite;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.SceneObject;
import biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene.sprites.TextSprite;
import org.w3c.dom.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//import biz.kulik.android.jaxb.library.DocUtils;

/**
 * User: kulik
 * Date: 9/18/12
 * Time: 6:34 PM
 */
public class TestJavaTypeAdapter1Compouser extends AndroidTestCase {
    private static final String TAG = TestJavaTypeAdapter1Compouser.class.getSimpleName();

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public void testCompouseXML() {
        Geometry geometry;
        SceneObject sceneObject;

        Scene scene = new Scene();
        scene.width = 1024;
        scene.height = 768;

        geometry = new Geometry(0.25f, 0.25f, 0.25f, 0.25f, 0.0f);
        sceneObject = new PhotoSprite("data/picture1.jpg", 0, geometry);
        scene.sceneObjects.add(sceneObject);

        geometry = new Geometry(-0.25f, 0.25f, 0.25f, 0.25f, 0.0f);
        sceneObject = new PhotoSprite("data/picture2.jpg", 0, geometry);
        scene.sceneObjects.add(sceneObject);

        geometry = new Geometry(0.25f, -0.25f, 0.25f, 0.25f, 0.0f);
        sceneObject = new PhotoSprite("data/picture3.jpg", 0, geometry);
        scene.sceneObjects.add(sceneObject);

        geometry = new Geometry(-0.25f, -0.25f, 0.25f, 0.25f, 0.0f);
        sceneObject = new PhotoSprite("data/picture4.jpg", 0, geometry);
        scene.sceneObjects.add(sceneObject);

        geometry = new Geometry(0.0f, 0.0f, 0.25f, 0.25f, 0.0f);
        sceneObject = new PhotoSprite("data/picture5.jpg", 100, geometry);
        scene.sceneObjects.add(sceneObject);

        geometry = new Geometry(0.5f, 0.0f, 0.25f, 0.25f, 0.0f);
        sceneObject = new TextSprite("Bla-bla-bla", geometry);
        scene.sceneObjects.add(sceneObject);

        Composer composer = new ComposerImpl(ProviderTypes.XMLProvider);

        try {
            UMO umo = (UMO) composer.compose(scene);

            Log.v(TAG, DocUtils.getStringFromDoc((Document) umo.getRootDocument()));
            assertEquals(DocUtils.getStringFromDoc((Document) umo.getRootDocument()), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<scene>" +
                    "<sprites>" +
                    "<sprite type=\"Photo\">" +
                    "<geometry angle=\"0.0\" centerX=\"0.25\" centerY=\"0.25\" height=\"0.25\" width=\"0.25\"/>" +
                    "<photo fileName=\"data/picture1.jpg\" slotNo=\"0\"/>" +
                    "</sprite>" +
                    "<sprite type=\"Photo\">" +
                    "<geometry angle=\"0.0\" centerX=\"-0.25\" centerY=\"0.25\" height=\"0.25\" width=\"0.25\"/>" +
                    "<photo fileName=\"data/picture2.jpg\" slotNo=\"0\"/>" +
                    "</sprite>" +
                    "<sprite type=\"Photo\">" +
                    "<geometry angle=\"0.0\" centerX=\"0.25\" centerY=\"-0.25\" height=\"0.25\" width=\"0.25\"/>" +
                    "<photo fileName=\"data/picture3.jpg\" slotNo=\"0\"/>" +
                    "</sprite>" +
                    "<sprite type=\"Photo\">" +
                    "<geometry angle=\"0.0\" centerX=\"-0.25\" centerY=\"-0.25\" height=\"0.25\" width=\"0.25\"/>" +
                    "<photo fileName=\"data/picture4.jpg\" slotNo=\"0\"/>" +
                    "</sprite>" +
                    "<sprite type=\"Photo\">" +
                    "<geometry angle=\"0.0\" centerX=\"0.0\" centerY=\"0.0\" height=\"0.25\" width=\"0.25\"/>" +
                    "<photo fileName=\"data/picture5.jpg\" slotNo=\"100\"/>" +
                    "</sprite>" +
                    "<sprite type=\"Text\">" +
                    "<geometry angle=\"0.0\" centerX=\"0.5\" centerY=\"0.0\" height=\"0.25\" width=\"0.25\"/>" +
                    "<text text=\"Bla-bla-bla\" fontSize=\"0\"/>" +
                    "</sprite>" +
                    "</sprites>" +
                    "<scene_height>768</scene_height>" +
                    "<scene_width>1024</scene_width>" +
                    "</scene>");
        } catch (AdapterException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
