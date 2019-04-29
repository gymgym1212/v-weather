package com.example.bigdata.pojo;

public class Screen {
    private int id;
    private int screen_id;
    private String screen_name;
    private String screen_url;
    private String screen_blocks;
    private String screen_status;

    public Screen() {}

    public Screen(int screen_id, String screen_name, String screen_url, String screen_blocks) {
        this.screen_id = screen_id;
        this.screen_name = screen_name;
        this.screen_url = screen_url;
        this.screen_blocks = screen_blocks;
    }

    public Screen(int id, int screen_id, String screen_name, String screen_url, String screen_blocks, String screen_status) {
        this.id = id;
        this.screen_id = screen_id;
        this.screen_name = screen_name;
        this.screen_url = screen_url;
        this.screen_blocks = screen_blocks;
        this.screen_status = screen_status;
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

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getScreen_url() {
        return screen_url;
    }

    public void setScreen_url(String screen_url) {
        this.screen_url = screen_url;
    }

    public String getScreen_blocks() {
        return screen_blocks;
    }

    public void setScreen_blocks(String screen_blocks) {
        this.screen_blocks = screen_blocks;
    }

    public String getScreen_status() {
        return screen_status;
    }

    public void setScreen_status(String screen_status) {
        this.screen_status = screen_status;
    }
}
