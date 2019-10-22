package com.example.sultanahmed.crimenewsbd;


public class NewsUnit {
    String title;
    String news;
    String time;
    String location;

    public NewsUnit(String title, String news, String time, String location) {
        this.title = title;
        this.news = news;
        this.time = time;
        this.location = location;
    }

    public NewsUnit() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
