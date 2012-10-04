package biz.mobidev.android.jaxb.library.composer;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderFactory {

    public static UniversalMarshalObject createProvider(ProviderTypes type, Object data) {
         UniversalMarshalObject provider = null;
         switch (type){
             case XMLProvider:
                 provider = new XMLUnivObject(data);
                 break;
//             case JSONProvider:
//                 provider = new JSONProvider(data);
//                 break;
             default:
                 throw new IllegalArgumentException("This type of provider is not inplemented yet.");
         }
        return provider;
    }
}
