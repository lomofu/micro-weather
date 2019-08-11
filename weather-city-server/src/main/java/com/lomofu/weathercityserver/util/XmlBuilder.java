package com.lomofu.weathercityserver.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlBuilder {
    public static Object xmlToOb(Class<?> c,String xmlString) throws Exception{
        Object object =null;
        JAXBContext context = JAXBContext.newInstance(c);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(xmlString));
    }
}
