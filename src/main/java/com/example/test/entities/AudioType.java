package com.example.test.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="AudioType")
public class AudioType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(mappedBy="audioType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Audio> audio;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Audio> getAudio() {
        return audio;
    }

    public void setAudio(List<Audio> audio) {
        this.audio = audio;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
