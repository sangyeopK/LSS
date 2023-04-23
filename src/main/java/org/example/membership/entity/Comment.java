package org.example.membership.entity;

public class Comment {
    private final String comment;
    private final int id;
    private final int postId;

    public Comment(int id, int postId, String comment){
        this.id = id;
        this.comment = comment;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getComment() {
        return comment;
    }
}
