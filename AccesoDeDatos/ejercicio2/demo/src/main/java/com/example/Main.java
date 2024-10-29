package com.example;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Leemos el archivo XML
            File arxiuXML = new File("llibres.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(arxiuXML);

            // Buscamos el elemento con el nombre: llibre
            doc.getDocumentElement().normalize();
            NodeList llistaLlibres = doc.getElementsByTagName("llibre");

            // HAcemos un bucle de lista de libros y mostramos los datos
            for (int i = 0; i < llistaLlibres.getLength(); i++) {
                Node nodeLlibre = llistaLlibres.item(i);

                if (nodeLlibre.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementLlibre = (Element) nodeLlibre;
                    // Aqui obtemos la informacion de cada libro y le asignamos a una variable
                    String titol = elementLlibre.getElementsByTagName("titol").item(0).getTextContent();
                    String autor = elementLlibre.getElementsByTagName("autor").item(0).getTextContent();
                    String any = elementLlibre.getElementsByTagName("any").item(0).getTextContent();
                    String resum = elementLlibre.getElementsByTagName("resum").item(0).getTextContent();

                    // Aqui imprimimos por consola toda la información de cada libro
                    System.out.println("Titulo: " + titol);
                    System.out.println("Autor: " + autor);
                    System.out.println("Año: " + any);
                    System.out.println("Resumen: " + resum);
                    System.out.println("------------------------");
                }
            }
        } // Capturamos cualquier excepción que pueda ocurrir
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}