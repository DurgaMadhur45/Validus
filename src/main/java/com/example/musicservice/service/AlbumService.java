package com.example.musicservice.service;

import com.example.musicservice.dao.AlbumRepository;
import com.example.musicservice.model.Album;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Album album) {
        Optional<Album> fetchedAlbum = albumRepository.findById(album.getId());
        return fetchedAlbum
                .map(x -> {
                    album.setCreated(x.getCreated());
                    return album;
                })
                .map(albumRepository::save)
                .orElseThrow(() -> new RuntimeException(" No album present with id: " + album.getId()));
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteById(id);
    }

    public void deleteAlbums() {
        albumRepository.deleteAll();
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public List<Album> getAlbum(String name) {
        return albumRepository.findByName(name);
    }

}
