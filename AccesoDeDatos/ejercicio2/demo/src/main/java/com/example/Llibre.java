package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "llibre")
public class Llibre {
    // Variables de la clase
    private String titol;
    private String autor;
    private String any;
    private String resum;

    // Getters y Setters
    @XmlElement
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @XmlElement
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement
    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    @XmlElement
    public String getResum() {
        return resum;
    }

    public void setResum(String resum) {
        this.resum = resum;
    }
}
