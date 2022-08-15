package com.example.musicservice.controller;

import com.example.musicservice.dao.ArtistRepository;
import com.example.musicservice.model.Artist;
import com.example.musicservice.service.ArtistService;
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
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/createArtist")
    public Artist saveArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping("/updateArtist")
    public Artist updateArtist(@RequestBody Artist artist) {
        return artistService.updateArtist(artist);
    }

    @DeleteMapping("/deleteArtist/{id}")
    public void deleteArtist(@PathVariable long id) {
        artistService.deleteArtist(id);
    }

    @DeleteMapping("/deleteAllArtist")
    public void deleteAllArtists() {
        artistService.deleteAllArtists();
    }

    @GetMapping("/getArtists")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/getArtist/{name}")
    public List<Artist> getArtist(@PathVariable String name) {
        return artistService.getArtist(name);
    }
}
