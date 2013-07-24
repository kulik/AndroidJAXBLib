package biz.kulik.android.jaxb.library.composer.providers.abstractProvider;

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
     * @return
     */
    public Object getWrappedObject();


    public void setWrappedObject(Object obj);

    /**
     * if you compouse into JSON it will return JSONObject or JSONArray depends on root element
     * if you compouse into XML it will return Document each time
     * @return
     */
    public Object getRootDocument();

}
