package com.example.afinal;

public class Note {
    String title;
    String time;
    String content;
    public Note()
    {

    }
    public Note(String title,String time) {
        this.title = title;
        this.time=time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

