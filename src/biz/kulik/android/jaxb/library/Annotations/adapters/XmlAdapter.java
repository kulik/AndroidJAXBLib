package biz.kulik.android.jaxb.library.Annotations.adapters;

/**
 * User: kulik
 * Date: 11/27/12
 * Time: 9:55 AM
 */
public abstract class XmlAdapter<ValueType, BoundType>{

    protected XmlAdapter() {}
    public abstract BoundType unmarshal(ValueType v) throws Exception;
    public abstract ValueType marshal(BoundType v) throws Exception;
}
