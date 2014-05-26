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
 * Time: 9:42 PM
 */
public interface UMOObject extends UMO {
    //TODO add primitive appenders
    //TODO add checking for null
    public void put(String key, UMO umo);

    public void putArray(String valueName, UMO value);

    public void putAttributeStr(String annotationName, String value);

    public void putAttributeInt(String annotationName, Integer value);

    public void putAttributeLong(String annotationName, Long value);

    public void putAttributeFloat(String annotationName, Float value);

    public void putAttributeDouble(String annotationName, Double value);

    public void putAttributeBoolean(String annotationName, Boolean value);


    public void putValueStr(String valueName, String value);

    public void putValueInt(String valueName, Integer value);

    public void putValueLong(String valueName, Long value);

    public void putValueFloat(String valueName, Float value);

    public void putValueDouble(String valueName, Double value);

    public void putValueBoolean(String valueName, Boolean value);

    public void putValueStr(String value);

    public void putValueInt(Integer value);

    public void putValueLong(Long value);

    public void putValueFloat(Float value);

    public void putValueDouble(Double value);

    public void putValueBoolean(Boolean value);


}
