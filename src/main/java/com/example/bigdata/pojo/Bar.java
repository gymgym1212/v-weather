package com.example.bigdata.pojo;

public class Bar {
    public int id;
    public int screen_id;
    public int option_id;
    public String title;
    public String color;
    public String unit;
    public String xaxis;
    public String yaxis;
    public String width;

    public Bar() {}

    public Bar(int screen_id, int option_id, String title, String color, String unit, String xaxis, String yaxis, String width) {
        this.screen_id = screen_id;
        this.option_id = option_id;
        this.title = title;
        this.color = color;
        this.unit = unit;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(int screen_id) {
        this.screen_id = screen_id;
    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    public String getYaxis() {
        return yaxis;
    }

    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
