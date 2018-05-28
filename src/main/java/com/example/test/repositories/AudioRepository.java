package com.example.test.repositories;

import com.example.test.entities.Audio;
import com.example.test.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AudioRepository extends JpaRepository<Audio,Integer> {
    Page<Audio> findAllByName(String musicName, Pageable pageable);

    @Query(value = "SELECT AUDIO.* FROM AUDIO INNER JOIN PLAY_AUDIO PA on AUDIO.ID = PA.AUDIO_ID WHERE PLAYLIST_ID = :playlistGoal ORDER BY AUDIO.NAME" +
            "",nativeQuery = true)
    Page<Audio> findAllByPlayAudio(@Param("playlistGoal") int playlistGoal ,Pageable pageable); //Взять по playlist

    @Query(value = "SELECT AUDIO.* FROM AUDIO INNER JOIN PLAY_AUDIO PA on AUDIO.ID = PA.AUDIO_ID WHERE PLAYLIST_ID = :playlistGoal AND AUDIO.NAME = :playListName ORDER BY AUDIO.NAME" +
            "",nativeQuery = true)
    Page<Audio> findAllByPlayAudio(@Param("playListName") String playListName, @Param("playlistGoal") int playlistGoal ,Pageable pageable);
}
//value = "SELECT Audio FROM Audio INNER JOIN PlayAudio ON audio.id = play_audio.audio_id WHERE PLAY_AUDIO.PLAYLIST_ID = :playlistGoal ORDER BY AUDIO.NAME"