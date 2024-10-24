package com.deepblue.mine_02_deepsource.example_005_stream_source;

/**
 * 物件 Bean
 */
public class Widget {
    //颜色
    private String color;
    //重量
    private int weight;

    public Widget(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
