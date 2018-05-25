package com.example.test.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="audio")
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String music; //Путь до файла в файловой системе
    private Date dateAdd; //Дата добавления
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id")
    private AudioType audioType;
    @OneToMany(mappedBy="audioId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PlayAudio> playAudio;

    Audio(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public AudioType getAudioType() {
        return audioType;
    }

    public void setAudioType(AudioType audioType) {
        this.audioType = audioType;
    }
}
