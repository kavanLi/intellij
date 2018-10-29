package com.capcom.mh.monster;

/**
 * Created by Ritchie on 9/10/2017.
 */


abstract public class Monster {
    public String name = "123";
    public double length;
    public double height;
    public double weight;
    public int hp;

    //private Monster() {
    //
    //}
    public class AB {

    }

    public void eat() {
        System.out.println("eat");
    }

    public void eat(int a) {
        System.out.println(a);
    }

    public void sleep() {
        System.out.println("sleep");
    }

    public void roam() {
        System.out.println("roam");
    }

    public void roar() {
        System.out.println("roar");
    }

    public void dash() {
        System.out.println("dash");
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", height=" + height +
                ", weight=" + weight +
                ", hp=" + hp +
                '}';
    }


}

