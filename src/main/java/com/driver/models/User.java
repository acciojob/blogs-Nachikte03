package com.driver.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String userName;
    String password;
    String firstName;
    String lastName;
    @OneToMany(targetEntity = Blog.class,cascade = CascadeType.ALL)
    List<Blog> BlogList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getBlogList() {
        return BlogList;
    }

    public void setBlogList(List<Blog> blogList) {
        BlogList = blogList;
    }
}