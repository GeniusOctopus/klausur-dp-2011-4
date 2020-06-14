package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PersonenHandler extends DefaultHandler {

    Person person;
    List<Person> personenListe;
    private String name;
    private String vorname;
    private String abteilung;
    private String postleitzahl;
    private String ort;
    private boolean isName = false;
    private boolean isVorname = false;
    private boolean isAbteilung = false;
    private boolean isPostleitzahl = false;
    private boolean isOrt = false;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        System.out.println("Das parsen der XML Datei beginnt...");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

        System.out.println("Das parsen der XML Datei endet...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("person")) {
            person = new Person();
            person.setId((Integer.parseInt(attributes.getValue("id"))));
        } else if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("vorname")) {
            isVorname = true;
        } else if (qName.equals("abteilung")) {
            isAbteilung = true;
        } else if (qName.equals("postleitzahl")) {
            isPostleitzahl = true;
        } else if (qName.equals("ort")) {
            isOrt = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        switch (qName) {
            case "person":
                if (personenListe == null)
                    personenListe = new ArrayList<>();

                personenListe.add(person);
                System.out.println(person.toString());
            case "name":
                person.setName(name);
            case "vorname":
                person.setVorname(vorname);
            case "abteilung":
                person.setAbteilung(abteilung);
            case "postleittzahl":
                person.setPostleitzahl(postleitzahl);
            case "ort":
                person.setOrt(ort);
        }

        isName = false;
        isVorname = false;
        isAbteilung = false;
        isPostleitzahl = false;
        isOrt = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (isName) {
            name = new String(ch, start, length);
        } else if (isVorname) {
            vorname = new String(ch, start, length);
        } else if (isAbteilung) {
            abteilung = new String(ch, start, length);
        } else if (isPostleitzahl) {
            postleitzahl = new String(ch, start, length);
        } else if (isOrt) {
            ort = new String(ch, start, length);
        }
    }
}
