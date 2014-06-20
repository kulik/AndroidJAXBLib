package com.kulik;

import com.kulik.compouserTest.RootProxy;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * User: kulik
 * Date: 3/14/13
 * Time: 1:40 PM
 */
public class JaxbTest {

    public static void main(String[] args) {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(RootProxy.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            RootProxy obj = new RootProxy();

//            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}