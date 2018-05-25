package com.example.test.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class PlayAudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="playlist_id")
    private PlayList playListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="audio_id")
    private Audio audioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
