package com.example.apicalling.Class;

public class ModelClass {
    String title;
    String body;

    public ModelClass(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
