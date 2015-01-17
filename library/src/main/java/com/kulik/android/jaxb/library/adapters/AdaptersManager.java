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
import com.kulik.android.jaxb.library.Annotations.adapters.XmlAdapter;
import com.kulik.android.jaxb.library.parser.methodFieldAdapter.FieldAdapter;
import com.kulik.android.jaxb.library.parser.methodFieldAdapter.MethodFieldAdapter;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 2:31 PM
 */
public class AdaptersManager {

    private AdapterChacheManager mJavaAdapterManager;
    private AbstractAdapterChacheManager mPackageAssignedAdaptersManager;

    public static enum ManagerType {
        PARSER, COMPOSER
    }

    public AdaptersManager(ManagerType type) {
        mJavaAdapterManager = new AdapterChacheManager();
        if (type == ManagerType.PARSER) {
            mPackageAssignedAdaptersManager = new ParserAdapterChacheManager();
        } else if (type == ManagerType.COMPOSER) {
            mPackageAssignedAdaptersManager = new ComposerAdapterChacheManager();
        }
    }

    public XmlAdapter getAdapterForField(MethodFieldAdapter methodFieldAdapter) {
        XmlAdapter adapter;
        if (methodFieldAdapter.isAnnotationPresent(XmlJavaTypeAdapter.class)) {
            XmlJavaTypeAdapter fieldLevelAnn = methodFieldAdapter.getAnnotation(XmlJavaTypeAdapter.class);
            adapter = mJavaAdapterManager.getAdapter(fieldLevelAnn.value());
            //TODO add debug mode Check class types compatibility
        } else {
            Package pack = methodFieldAdapter.getPackage();
            Class clazz = methodFieldAdapter.getClassClass();
            Class returnType = methodFieldAdapter.getInputType(); //TODO make shure that composer with methods should use another method
            mPackageAssignedAdaptersManager.process(pack, clazz, returnType);
            adapter = mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
        }

        return adapter;
    }

    public Object adaptMarshal(Object obj, FieldAdapter fieldAdapter) throws AdapterException {
        XmlAdapter adapter = getAdapterForField(fieldAdapter);
        Class<?> adapterValueType = XmlAdapter.getMarshalerType(adapter);
        if (!Object.class.equals(adapterValueType)) {
            return XmlAdapter.marshal(adapter, obj);
        }
        return obj;
    }


    public XmlAdapter getAdapterByProp(Package pack, Class clazz, Class returnType) {
        mPackageAssignedAdaptersManager.process(pack, clazz, returnType);
        return mPackageAssignedAdaptersManager.getAdapter(pack, clazz, returnType);
    }

    public Object adaptMarshal(Object obj, Package pack, Class<?> genericClass, Class<?> ownerClass) throws AdapterException {

        XmlAdapter adapter = getAdapterByProp(pack, ownerClass, genericClass);
        Class<?> adapterValueType = XmlAdapter.getMarshalerType(adapter);
        if (!Object.class.equals(adapterValueType)) {
            return XmlAdapter.marshal(adapter, obj);
        }
        return obj;
    }

}
