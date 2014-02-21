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