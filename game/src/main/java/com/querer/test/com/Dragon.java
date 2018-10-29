package com.querer.test.com;

import java.util.DoubleSummaryStatistics;

/**
 * Created by Ritchie on 2017/8/12.
 */
public class Dragon {

    private String name;
    private String type;
    private Integer life;
    private Double length;
    private Double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", life=" + life +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
