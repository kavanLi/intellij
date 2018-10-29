package com.kavan.mounsterhunter;

/**
 * Created by Ritchie on 8/30/2017.
 */

public class WantedMonster {
    Map weatherAndDaytime;
    private String type;
    private String species;
    private String name;
    private String habit;
    private Integer life;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String toString() {
        return "Monster{" + "type=" + type + ",species=" + species + ",name=" + name + ", habit=" + habit + ", life=" + life + "}";
    }

    void chooseMonster() {
        weatherAndDaytime = new Map();
        weatherAndDaytime.chooseMap();
    }
}
