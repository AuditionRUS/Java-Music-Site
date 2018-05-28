package com.example.test.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PLAY_AUDIO", uniqueConstraints = {@UniqueConstraint(columnNames = {"playlist_id","audio_id"})})
public class PlayAudio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="playlist_id", unique = true)
    private PlayList playListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="audio_id", unique = true)
    private Audio audioId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayAudio(){}

    public PlayAudio(PlayList playListId, Audio audioId) {
        this.playListId = playListId;
        this.audioId = audioId;
    }

    public PlayList getPlayListId() {
        return playListId;
    }

    public void setPlayListId(PlayList playListId) {
        this.playListId = playListId;
    }

    public Audio getAudioId() {
        return audioId;
    }

    public void setAudioId(Audio audioId) {
        this.audioId = audioId;
    }
}
