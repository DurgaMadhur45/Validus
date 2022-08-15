package com.example.musicservice.dao;

import com.example.musicservice.model.Album;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByName(String name);
}
