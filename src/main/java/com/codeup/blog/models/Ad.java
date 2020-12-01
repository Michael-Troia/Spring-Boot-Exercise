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

    //empty
    public Ad(){ }

    //todo CREATE
    public Ad(String title, String description){
        this.title = title;
        this.description = description;
    }


    //todo READ
    public Ad(long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
}


//todo add a new user and put the credentials in application.properties
//
//      Equivalent to:
//
//    CREATE TABLE ads (
//        id BIGINT NOT NULL AUTO_INCREMENT,
//        title VARCHAR(100) NOT NULL,
//    description VARCHAR(255) NOT NULL,
//    PRIMARY KEY (id)
//);