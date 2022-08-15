package com.example.musicservice.dao;

import com.example.musicservice.model.Artist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findByName(String name);
}
