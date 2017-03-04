package com.cbu.edu.hw_04;

@Json
public class Human {

    @JsonField(name = "Full name")
    private String name;

    @JsonField
    private int age;

    @JsonField
    private boolean married;

    @JsonField
    private int grows;

    @JsonField
    private String livingPlace;

    public Human(String name, int age, boolean married, int hight, String livingPlace) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.grows = hight;
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

    public int getHight() {
        return grows;
    }

    public void setHight(int hight) {
        this.grows = hight;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }
}
