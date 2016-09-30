package pl.ania;

import java.util.Date;

public class Cat {

    private String name;
    private String catSitterName;
    private Date birthDate;
    private Float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatSitterName() {
        return catSitterName;
    }

    public void setCatSitterName(String catSitterName) {
        this.catSitterName = catSitterName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String introduceYourself() {
        System.out.println("Jestem kotem o imieniu " + name + ". Moja data urodzenia to " + birthDate + ". Ważę " + weight + " kg. Imię omojego opiekuna to " + catSitterName + ".");
        return "Jestem kotem o imieniu " + name + ". Moja data urodzenia to " + birthDate + ". Ważę " + weight + " kg. Imię omojego opiekuna to " + catSitterName + ".";

    }
}
