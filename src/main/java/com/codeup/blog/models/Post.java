
package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    //    SQL setup
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User owner;

    //EMPTY
    public Post() {
    }

//    CREATE
    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

//    READ
    public Post(long id, String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.id = id;
        this.owner = owner;
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
    public long getId() { return id; }
    public void setId(long id){
        this.id = id;
    }
    public User getOwner(){
        return this.owner;
    }
    public void setOwner(User owner){
        this.owner = owner;
    }

}