package com.studentnetwork.feed.Feed;

public class Post {

    // id usera koji je postavio post
    private String userId;
    private String text;

    //Treba bi link do materijala koji se nalazi u bazi.

    public Post(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
