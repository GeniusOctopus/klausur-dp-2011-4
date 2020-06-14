package com.company;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.stream.XMLReporter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        PersonenHandler personenHandler = new PersonenHandler();
        xmlReader.setContentHandler(personenHandler);
        xmlReader.parse("personen.xml");
    }
}
