package br.com.sample.buscapais.bean;

import java.io.Serializable;

public class Continent implements Serializable {

    private String name;
    private String image;

    public Continent(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
