package com.example.test.repositories;

import com.example.test.entities.Audio;
import com.example.test.entities.PlayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayListRepository extends JpaRepository<PlayList,Integer> {
    @Query(value = "SELECT PLAY_LIST.* FROM PLAY_LIST WHERE PLAY_LIST.NAME = :playlistName AND PLAY_LIST.USER_ID = :playlistShow" +
            "",nativeQuery = true)
    Page<PlayList> findAllByName(@Param("playlistShow") int playlistShow,@Param("playlistName") String playlistName, Pageable pageable);

    @Query(value = "SELECT PLAY_LIST.* FROM PLAY_LIST WHERE PLAY_LIST.USER_ID = :playlistShow" +
            "",nativeQuery = true)
    Page<PlayList> findAllByName(@Param("playlistShow") int playlistShow, Pageable pageable);
}
