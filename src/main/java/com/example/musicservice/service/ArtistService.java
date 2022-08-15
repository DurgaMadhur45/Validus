package com.example.musicservice.service;

import com.example.musicservice.dao.ArtistRepository;
import com.example.musicservice.model.Artist;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @PostMapping("/createArtist")
    public Artist saveArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping("/updateArtist")
    public Artist updateArtist(@RequestBody Artist artist) {
        Optional<Artist> fetchedArtist = artistRepository.findById(artist.getId());
        return fetchedArtist
                .map(x -> {
                    artist.setCreated(x.getCreated());
                    return artist;
                })
                .map(artistRepository::save)
                .orElseThrow(() -> new RuntimeException(" No Artist present with id: " + artist.getId()));
    }

    @DeleteMapping("/deleteArtist/{id}")
    public void deleteArtist(@PathVariable long id) {
        artistRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllArtist")
    public void deleteAllArtists() {
        artistRepository.deleteAll();
    }

    @GetMapping("/getArtists")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/getArtist/{name}")
    public List<Artist> getArtist(@PathVariable String name) {
        return artistRepository.findByName(name);
    }
}
