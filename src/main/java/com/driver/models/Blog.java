package com.driver.models;



import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String Content;
    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    List<Image> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getList() {
        return list;
    }

    public void setList(List<Image> list) {
        this.list = list;
    }
}