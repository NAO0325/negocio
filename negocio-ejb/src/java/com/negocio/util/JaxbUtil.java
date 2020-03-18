/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author root
 */
public class JaxbUtil {

    public static String objectToXML(Object obj) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(obj, sw);
            return getLegalXml(sw.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T xmlToObject(String xml, Class<T> c) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(c);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(getLegalXml(xml));
            T obj = (T) jaxbUnmarshaller.unmarshal(reader);
            return obj;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getLegalXml(String xml) {
        String xml10pattern = "[^"
                + "\u0009\r\n"
                + "\u0020-\uD7FF"
                + "\uE000-\uFFFD"
                + "\ud800\udc00-\udbff\udfff"
                + "]";

        String xml11pattern = "[^"
                + "\u0001-\uD7FF"
                + "\uE000-\uFFFD"
                + "\ud800\udc00-\udbff\udfff"
                + "]+";

        String result = xml.replaceAll(xml10pattern, "");
        result = result.replaceAll(xml11pattern, "");

        return result;
    }
}
