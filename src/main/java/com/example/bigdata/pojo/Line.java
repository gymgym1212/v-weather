package com.example.bigdata.pojo;

public class Line {

    public int id;
    public int screen_id;
    public int option_id;
    public String title;
    public String color;
    public String unit;
    public String xaxis;
    public String yaxis;

    public Line() {}

    public Line(int screen_id, int option_id, String title, String color, String unit, String xaxis, String yaxis) {
        this.screen_id = screen_id;
        this.option_id = option_id;
        this.title = title;
        this.color = color;
        this.unit = unit;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
