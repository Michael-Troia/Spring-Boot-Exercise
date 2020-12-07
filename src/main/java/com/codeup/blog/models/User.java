package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity //makes it into SQL compatible with JPA
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increments ID
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(){ }

    public User(User copy){
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
//todo the above is equal to the following SQL
//    CREATE TABLE ads (
//    id BIGINT NOT NULL AUTO_INCREMENT,
//    title VARCHAR(255) NOT NULL,
//    description VARCHAR(255),
//    owner_id BIGINT NOT NULL,
//    PRIMARY KEY (id),
//    FOREIGN KEY (owner_id) REFERENCES users(id)
//);

    //READ
    public User(long id, String email, String username, String password){
        this.email = email;
        this.id = id;
        this.password = password;
        this.username = username;
    }

    //CREATE
    public User(String email, String username, String password) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }
    public String getUsername() { return username; }
    public void setUsername (String username) { this.username = username; }
    public void setEmail(String email) {  this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
//    public List<Post> getPosts(){ return posts; }
}
