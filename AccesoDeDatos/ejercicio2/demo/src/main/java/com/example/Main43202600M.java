package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main43202600M {
    public static void main(String[] args) {
        try {
            // Creamos el contexto de JAXB y el unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Llibres.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Leemos el archivo XML y lo convertimos en una lista de objetos de la clase
            File arxiuXML = new File("llibres.xml");
            Llibres llibres = (Llibres) jaxbUnmarshaller.unmarshal(arxiuXML);

            // Recorremos la lista de libros y mostramos la información
            List<Llibre> llistaLlibres = llibres.getLlibres();
            for (Llibre llibre : llistaLlibres) {
                System.out.println("Titulo: " + llibre.getTitol());
                System.out.println("Autor: " + llibre.getAutor());
                System.out.println("Año: " + llibre.getAny());
                System.out.println("Resumen: " + llibre.getResum());
                System.out.println("------------------------");
            }

        } // Capturamos cualquier excepción que pueda ocurrir
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
