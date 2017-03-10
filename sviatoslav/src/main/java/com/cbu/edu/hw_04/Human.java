package com.cbu.edu.hw_04;

@Json
public class Human {

    @JsonField(name = "Full name")
    private String name;

    @JsonField(name = "Age")
    private int age;

    @JsonField(name = "Married")
    private boolean married;

    @JsonField(name = "Grows")
    private int grows;

    @JsonField(name = "Address")
    private String livingPlace;


    public Human(String name, int age, boolean married, int grows, String livingPlace) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.grows = grows;
        this.livingPlace = livingPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getGrows() {
        return grows;
    }

    public void setGrows(int grows) {
        this.grows = grows;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }
}
