package com.example.musicservice.controller;

import com.example.musicservice.model.Album;
import com.example.musicservice.service.AlbumService;
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
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/createAlbum")
    public Album saveAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    @PutMapping("/updateAlbum")
    public Album updateAlbum(@RequestBody Album album) {
        return albumService.updateAlbum(album);
    }

    @DeleteMapping("/deleteAlbum/{id}")
    public void deleteAlbum(@PathVariable long id) {
        albumService.deleteAlbum(id);
    }

    @DeleteMapping("/deleteAllAlbums")
    public void deleteAlbums() {
        albumService.deleteAlbums();
    }

    @GetMapping("/getAlbums")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/getAlbum/{name}")
    public List<Album> getAlbum(@PathVariable String name) {
        return albumService.getAlbum(name);
    }

}
