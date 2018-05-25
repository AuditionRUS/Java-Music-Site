package com.example.test.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user_id;
    private String name;
    private Date dateAdd;
    @OneToMany(mappedBy="playListId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PlayAudio> playAudio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Set<PlayAudio> getPlayAudio() {
        return playAudio;
    }

    public void setPlayAudio(Set<PlayAudio> playAudio) {
        this.playAudio = playAudio;
    }
}
