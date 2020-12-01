package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    public Ad(){

    }

    public Ad(long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
}


//todo add a new user and put the credentials in application.properties