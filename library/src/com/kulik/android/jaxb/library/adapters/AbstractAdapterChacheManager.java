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

import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 10:52 AM
 */
public abstract class AbstractAdapterChacheManager {
    private static final String TAG = AbstractAdapterChacheManager.class.getSimpleName();

    protected static final XmlAdapter<Object, Object> DEFAULT_XML_ADAPTER = new XmlAdapter<Object, Object>() {
        @Override
        public Object unmarshal(Object v) throws Exception {
            return v;
        }

        @Override
        public Object marshal(Object v) throws Exception {
            return v;
        }
    };

    protected HashMap<Criteria, XmlAdapter> mAdaptersChache;

    private Set<Package> mProcessedPackages;
    private Set<Class<?>> mProcessedCasses;

    private Criteria mChacheCriteria;

    public AbstractAdapterChacheManager() {
        mAdaptersChache = new HashMap<Criteria, XmlAdapter>();
        mProcessedPackages = new LinkedHashSet<Package>();
        mProcessedCasses = new LinkedHashSet<Class<?>>();
        mChacheCriteria = new Criteria();
    }

    /**
     * add to Chache instance of all XMLAdapter declared for it package
     */
    public abstract void process(Package pack, Class clazz, Class returnType);

    public abstract XmlAdapter getAdapter(Package pack, Class clazz, Class returnType);
}
