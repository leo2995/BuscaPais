package br.com.sample.buscapais.bean;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable{

    private String name;
    private String subregion;
    private String flag;
    private long population;
    private List<String> borders;

    public Country(){

    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }
}
