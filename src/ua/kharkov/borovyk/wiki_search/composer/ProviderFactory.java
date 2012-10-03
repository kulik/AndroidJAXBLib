package ua.kharkov.borovyk.wiki_search.composer;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created with IntelliJ IDEA.
 * User: nata
 * Date: 9/21/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderFactory {

    public static Provider createProvider(ProviderTypes type, Object data) throws ParserConfigurationException {
         Provider provider = null;
         switch (type){
             case XMLProvider:
                 provider = new XMLProvider(data);
                 break;
             case JSONProvider:
                 provider = new JSONProvider(data);
                 break;
             default:
                 throw new IllegalArgumentException("This type of provider is not inplemented yet.");
         }
        return provider;
    }
}
