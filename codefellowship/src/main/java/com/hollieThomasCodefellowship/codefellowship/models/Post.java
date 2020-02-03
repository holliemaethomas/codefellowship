package com.hollieThomasCodefellowship.codefellowship.models;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String body;
    String createdAt;

    @ManyToOne
     ApplicationUser user;

//    generic structor
    public Post() {}

    public Post(String body, String createdAt, ApplicationUser user){
        this.body = body;
        this.createdAt = createdAt;
        this.user = user;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public Long getId() {
        return id;
    }

}






