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
package com.kulik.android.jaxb.library.parserTest.TestDataPrimitive;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

/**
 * User: kulik
 * Date: 16.01.13
 * Time: 17:55
 */
public class PrimitivesTypes {

    @XmlElement(name = "primByte")
    public byte primByte;

    @XmlElement(name = "primInt")
    public int primInt;

    @XmlElement(name = "primFloat")
    public float primFloat;

    @XmlElement(name = "primShort")
    public short primShort;

    @XmlElement(name = "primLong")
    public long primLong;

    @XmlElement(name = "primBool")
    public boolean primBool;

    @XmlElement(name = "primDouble")
    public double primDouble;


}