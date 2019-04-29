package com.example.bigdata.pojo;



public class AirIndex {

    private String cityName;
    private float co;
    private int no2;
    private int so2;
    private int o3;

    public AirIndex() {}

    public AirIndex(String cityName, float co, int no2, int so2, int o3) {
        this.cityName = cityName;
        this.co = co;
        this.no2 = no2;
        this.so2 = so2;
        this.o3 = o3;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getCo() {
        return co;
    }

    public void setCo(float co) {
        this.co = co;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }
}
