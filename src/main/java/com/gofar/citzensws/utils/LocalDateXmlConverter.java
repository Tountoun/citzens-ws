package com.gofar.citzensws.utils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class LocalDateXmlConverter {

    public static LocalDate unmarshal(XMLGregorianCalendar xmlGregorianCalendar) {
        return LocalDate.of(xmlGregorianCalendar.getYear(), xmlGregorianCalendar.getMonth(), xmlGregorianCalendar.getDay());
    }

    public static XMLGregorianCalendar marshal(LocalDate localDate) throws Exception {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
    }
}
