package com.example.musicservice.controller;

import com.example.musicservice.model.Song;
import com.example.musicservice.service.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/createSong")
    public Song saveSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @PutMapping("/updateSong")
    public Song updateSong(@RequestBody Song song) {
        return songService.updateSong(song);
    }

    @DeleteMapping("/deleteSong/{id}")
    public void deleteSong(@PathVariable long id) {
        songService.deleteSong(id);
    }

    @DeleteMapping("/deleteAllSongs")
    public void deleteSongs() {
        songService.deleteSongs();
    }

    @GetMapping("/getASongs")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/getSong/{name}")
    public List<Song> getSong(@PathVariable String name) {
        return songService.getSong(name);
    }
}
