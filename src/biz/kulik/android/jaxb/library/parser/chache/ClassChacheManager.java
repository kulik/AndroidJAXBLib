package biz.kulik.android.jaxb.library.parser.chache;

import java.util.HashMap;
import java.util.List;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class ClassChacheManager {
    private static final String TAG = ClassChacheManager.class.getSimpleName();

    private HashMap<Class<?>, List<ChacheField>> attributesChache;
    private HashMap<Class<?>, List<ChacheField>> elementsChache;

    public ClassChacheManager() {
        attributesChache = new HashMap<Class<?>, List<ChacheField>>();
        elementsChache = new HashMap<Class<?>, List<ChacheField>>();
    }

    /**
     * Pushing List of anotated by {@link biz.kulik.android.jaxb.library.Annotations.XmlAttribute} and <br/>
     * {@link biz.kulik.android.jaxb.library.Annotations.XmlElement} to chache.
     * @param clazz - necessary class
     * @return instance of necessary List of accessor fields, if
     */
    public void pushFieldsToCache(Class<?> clazz, List<ChacheField> attributesFields, List<ChacheField> elementsFields) {
        attributesChache.put(clazz, attributesFields);
        elementsChache.put(clazz, elementsFields);
    }

    public List<ChacheField> getChachedElementsFieldList(Class<?> clazz) {
        return elementsChache.get(clazz);
    }

    public List<ChacheField> getChachedAttributesFieldList(Class<?> clazz) {
        return attributesChache.get(clazz);
    }
}
