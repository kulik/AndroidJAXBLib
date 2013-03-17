package biz.kulik.android.jaxb.library.parser.chache;

import biz.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldFactory;

import java.util.HashMap;
import java.util.List;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class ClassCacheManager {
    private static final String TAG = ClassCacheManager.class.getSimpleName();

    private HashMap<Class<?>, List<CacheEntity>> mAttributesFieldsChache;
    private HashMap<Class<?>, List<CacheEntity>> mElementsFieldsChache;
    private HashMap<Class<?>, List<CacheEntity>> mAttributesMethodsChache;
    private HashMap<Class<?>, List<CacheEntity>> mElementsMethodsChache;

    public ClassCacheManager() {
        mAttributesFieldsChache = new HashMap<Class<?>, List<CacheEntity>>();
        mElementsFieldsChache = new HashMap<Class<?>, List<CacheEntity>>();
        mAttributesMethodsChache = new HashMap<Class<?>, List<CacheEntity>>();
        mElementsMethodsChache = new HashMap<Class<?>, List<CacheEntity>>();
    }

    /**
     * Pushing List of anotated by {@link biz.kulik.android.jaxb.library.Annotations.XmlAttribute} and <br/>
     * {@link biz.kulik.android.jaxb.library.Annotations.XmlElement} to chache.
     *
     * @param clazz - necessary class
     * @return instance of necessary List of accessor fields, if
     */
    public void pushEntityToCache(Class<?> clazz,
                                  List<CacheEntity> attributesEntities,
                                  List<CacheEntity> elementsEntities,
                                  MethodFieldFactory.EntityType entityType) {

        switch (entityType) {
            case FIELDS:
                mAttributesFieldsChache.put(clazz, attributesEntities);
                mElementsFieldsChache.put(clazz, elementsEntities);
                break;
            case METHODS:
                mAttributesMethodsChache.put(clazz, attributesEntities);
                mElementsMethodsChache.put(clazz, elementsEntities);
                break;
            default:
                throw new UnsupportedOperationException("Can't find cache with current entity type for fields");
        }
    }


    public List<CacheEntity> getChachedElementsEntityList(Class<?> clazz, MethodFieldFactory.EntityType entityType) {
        switch (entityType) {
            case FIELDS:
                return mElementsFieldsChache.get(clazz);
            case METHODS:
                return mElementsMethodsChache.get(clazz);
            default:
                throw new UnsupportedOperationException("Can't find cache with current entity type for methods");
        }
    }

    public List<CacheEntity> getChachedAttributesEntityList(Class<?> clazz, MethodFieldFactory.EntityType entityType) {
        switch (entityType) {
            case FIELDS:
                return mAttributesFieldsChache.get(clazz);
            case METHODS:
                return mAttributesMethodsChache.get(clazz);
            default:
                throw new NoSuchMethodError();
        }
    }
}
