package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "llibres")

public class Llibres {
    // Lista de libros
    private List<Llibre> llibres;

    // Getters y Setters
    @XmlElement(name = "llibre")
    public List<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(List<Llibre> llibres) {
        this.llibres = llibres;
    }
}
