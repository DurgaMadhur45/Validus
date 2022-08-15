package com.example.musicservice.dao;

import com.example.musicservice.model.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByName(String name);
}
