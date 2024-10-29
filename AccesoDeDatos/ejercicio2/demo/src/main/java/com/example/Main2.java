package com.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main2 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                // Variables para saber en que elemento estamos
                boolean titol = false;
                boolean autor = false;
                boolean any = false;
                boolean resum = false;

                // Metodo que se ejecuta al encontrar un elemento
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("titol")) {
                        titol = true;
                    } else if (qName.equalsIgnoreCase("autor")) {
                        autor = true;
                    } else if (qName.equalsIgnoreCase("any")) {
                        any = true;
                    } else if (qName.equalsIgnoreCase("resum")) {
                        resum = true;
                    }
                }

                // Metodo que se ejecuta al encontrar texto
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (titol) {
                        System.out.println("Títol: " + new String(ch, start, length));
                        titol = false;
                    } else if (autor) {
                        System.out.println("Autor: " + new String(ch, start, length));
                        autor = false;
                    } else if (any) {
                        System.out.println("Any: " + new String(ch, start, length));
                        any = false;
                    } else if (resum) {
                        System.out.println("Resum: " + new String(ch, start, length));
                        resum = false;
                    }
                }

                // Metodo que se ejecuta al encontrar un elemento
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("llibre")) {
                        System.out.println("------------------------");
                    }
                }
            };
            saxParser.parse("llibres.xml", handler);
        } // Capturamos cualquier excepción que pueda ocurrir
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
