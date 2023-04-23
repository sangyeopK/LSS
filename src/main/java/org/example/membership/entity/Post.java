package org.example.membership.entity;

public class Post {
    private final String content;
    private final String title;
    private final int id;

    public Post(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
