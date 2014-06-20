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
package com.kulik.android.jaxb.library.composer.providers.abstractProvider;

/**
 * User: kulik
 * Date: 10/11/12
 * Time: 9:33 PM
 * UMO - Universal Marshal Object
 * it is only container you JSONObject, JSONArray, Document
 */
public interface UMO {

    /**
     * if you compouse into JSON it will return JSONObject or JSONArray depends on root element
     * if you compouse into XML it will return root xmlElement  Element(Node)
     *
     * @return
     */
    public Object getWrappedObject();


    public void setWrappedObject(Object obj);

    /**
     * if you compouse into JSON it will return JSONObject or JSONArray depends on root element
     * if you compouse into XML it will return Document each time
     *
     * @return
     */
    public Object getRootDocument();

}
