package com.example.musicservice.service;

import com.example.musicservice.dao.SongRepository;
import com.example.musicservice.model.Song;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Song song) {
        Optional<Song> fetchedSong = songRepository.findById(song.getId());
        return fetchedSong
                .map(x -> {
                    song.setCreated(x.getCreated());
                    return song;
                })
                .map(songRepository::save)
                .orElseThrow(() -> new RuntimeException(" No Song present with id: " + song.getId()));
    }

    public void deleteSong(long id) {
        songRepository.deleteById(id);
    }

    public void deleteSongs() {
        songRepository.deleteAll();
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSong(String name) {
        return songRepository.findByName(name);
    }
}
