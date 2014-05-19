package com.kulik.android.jaxb.library.parser.chache;

import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kulik on 5/19/14.
 */
public class ChacheEntities {

    private final ClassCacheManager mClassCacheManager;

    public ChacheEntities() {
        mClassCacheManager = new ClassCacheManager();
    }

    public Chache getChacheForClass(Class<?> clazz, MethodFieldFactory.EntityType entityType) {

        List<CacheEntity> attributesEntity = mClassCacheManager.getChachedAttributesEntityList(clazz, entityType);
        List<CacheEntity> elementsEntity = mClassCacheManager.getChachedElementsEntityList(clazz, entityType);
        List<CacheWrapperEntity> wrappersEntity = mClassCacheManager.getChachedWrappedElementsEntityList(clazz, entityType);
        List<CacheEntity> valueEntity = mClassCacheManager.getChachedValueEntityList(clazz, entityType);
        if (attributesEntity != null && elementsEntity != null && wrappersEntity != null && valueEntity != null) {
            return new Chache(attributesEntity, elementsEntity, wrappersEntity, valueEntity);
        }
        return null;
    }

    public Chache initChacheForClass(Class<?> clazz, MethodFieldFactory.EntityType entityType) {
        return new Chache();
    }

    public void push(Chache chache, Class<?> clazz, MethodFieldFactory.EntityType entityType) {
        mClassCacheManager.pushEntityToCache(clazz, chache.mAttributesEntity, chache.mElementsEntity, chache.mWrappersEntity, chache.mValueEntity, entityType);
    }


    public class Chache {

        List<CacheEntity> mAttributesEntity;
        List<CacheEntity> mElementsEntity;
        List<CacheWrapperEntity> mWrappersEntity;
        List<CacheEntity> mValueEntity;

        public Chache() {
            mAttributesEntity = new LinkedList<CacheEntity>();//allEntity.length % 3 * 2);
            mElementsEntity = new LinkedList<CacheEntity>();
            mWrappersEntity = new LinkedList<CacheWrapperEntity>();//2
            mValueEntity = new LinkedList<CacheEntity>();
        }

        private Chache(List<CacheEntity> attributesEntity, List<CacheEntity> elementsEntity, List<CacheWrapperEntity> wrappersEntity, List<CacheEntity> valueEntity) {
            mAttributesEntity = attributesEntity;
            mElementsEntity = elementsEntity;
            mWrappersEntity = wrappersEntity;
            mValueEntity = valueEntity;
        }

        public List<CacheEntity> getAttributesEntity() {
            return mAttributesEntity;
        }

        public List<CacheEntity> getElementsEntity() {
            return mElementsEntity;
        }

        public List<CacheWrapperEntity> getWrappersEntity() {
            return mWrappersEntity;
        }

        public List<CacheEntity> getValuesEntity() {
            return mValueEntity;
        }
    }
}