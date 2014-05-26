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
package com.kulik.android.jaxb.library.adapters;

import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapter;
import com.kulik.android.jaxb.library.Annotations.XmlJavaTypeAdapters;
import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public class ComposerAdapterChacheManager extends AbstractAdapterChacheManager {
    private static final String TAG = ComposerAdapterChacheManager.class.getSimpleName();

    private HashMap<Criteria, XmlAdapter> adaptersChache;

    //    private Set<Package> processedPackages;
    private Set<Class<?>> processedCasses;

    private Criteria mChacheCriteria;

    public ComposerAdapterChacheManager() {
        adaptersChache = new HashMap<Criteria, XmlAdapter>();
//        processedPackages = new LinkedHashSet<Package>();
        processedCasses = new LinkedHashSet<Class<?>>();
        mChacheCriteria = new Criteria();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     */
    @Override
    public void process(Package pack, Class clazz, Class returnType) {

        try {
            XmlAdapter adapterInstance;
//            if (pack !=null && !processedPackages.contains(pack)) {
//                if (pack.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
//                    XmlJavaTypeAdapters ann = pack.getAnnotation(XmlJavaTypeAdapters.class);
//                    XmlJavaTypeAdapter[] adapters = ann.value();
//                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
//                        adapterInstance = adapterMetaData.value().newInstance();
//                        adaptersChache.put(new Criteria(pack, null, XmlAdapter.getMarshalerType(adapterInstance), null),  adapterInstance);
//                    }
//                }
//                if (pack.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
//                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) pack.getAnnotation(XmlJavaTypeAdapter.class);
//                    adapterInstance = adapterMetaData.value().newInstance();
//                    adaptersChache.put(new Criteria(pack, null, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
//                }
//                processedPackages.add(pack);
//            }
            if (clazz != null && !processedCasses.contains(clazz)) {
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapters.class)) {
                    XmlJavaTypeAdapters ann = (XmlJavaTypeAdapters) clazz.getAnnotation(XmlJavaTypeAdapters.class);
                    XmlJavaTypeAdapter[] adapters = ann.value();
                    for (XmlJavaTypeAdapter adapterMetaData : ann.value()) {
                        adapterInstance = adapterMetaData.value().newInstance();
                        adaptersChache.put(new Criteria(null, clazz, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
                    }
                }
                if (clazz.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
                    XmlJavaTypeAdapter adapterMetaData = (XmlJavaTypeAdapter) clazz.getAnnotation(XmlJavaTypeAdapter.class);
                    adapterInstance = adapterMetaData.value().newInstance();
                    adaptersChache.put(new Criteria(null, clazz, XmlAdapter.getMarshalerType(adapterInstance), null), adapterInstance);
                }
                processedCasses.add(clazz);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public XmlAdapter getAdapter(Package pack, Class clazz, Class returnType) {
        XmlAdapter adapter = null;

        if (adaptersChache.containsKey(mChacheCriteria.set(null, clazz, returnType, null))) {
            adapter = adaptersChache.get(mChacheCriteria);
        } else if (adaptersChache.containsKey(mChacheCriteria.set(pack, null, returnType, null))) {
            adapter = adaptersChache.get(mChacheCriteria);
        } else {
            adapter = DEFAULT_XML_ADAPTER;
        }
        return adapter;
    }
}
