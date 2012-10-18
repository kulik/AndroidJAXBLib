package biz.mobidev.android.jaxb.library.composer.providers;

import biz.mobidev.android.jaxb.library.composer.providers.jsonProvider.JSONArrayProvider;
import biz.mobidev.android.jaxb.library.composer.providers.jsonProvider.JSONObjectProvider;
import biz.mobidev.android.jaxb.library.composer.providers.abstractProvider.UMO;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 4:14 PM
 */
public class ProviderFactory {

    public static UMO createProvider(ProviderTypes type, ObjectType objType) {
         UMO provider = null;
         switch (type){
//             case XMLProvider:
//                 provider = new XMLUnivObject(data);
//                 break;
             case JSONProvider:
                 switch (objType) {
                     case ARRAY:
                        provider = new JSONArrayProvider();
                         break;
                     case OBJECT:
                        provider = new JSONObjectProvider();
                         break;
                 }
                 break;
             default:
                 throw new IllegalArgumentException("This type of provider is not inplemented yet.");
         }
        return provider;
    }
}
