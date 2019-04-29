package com.example.bigdata.model;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Date;

public class OutMessage {
    private String from;
    private String content;
    private Object body;
    private Object view;
    private Date time = new Date();

    public OutMessage(){}

    public OutMessage(String content, Object body, Object view) {this.content = content; this.body = body; this.view = view;}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }
}
