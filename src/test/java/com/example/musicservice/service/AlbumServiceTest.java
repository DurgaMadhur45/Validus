package com.example.musicservice.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.dao.AlbumRepository;
import com.example.musicservice.model.Album;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @Mock
    private AlbumRepository mockAlbumRepository;

    @InjectMocks
    private AlbumService albumService;


    @Test
    void testSaveAlbum() {
        Album expectedAlbum = Album.builder().name("Name").yearReleased(2022).build();
        when(mockAlbumRepository.save(expectedAlbum)).thenReturn(expectedAlbum);
        var actualAlbum = albumService.saveAlbum(expectedAlbum);
        assertThat(actualAlbum, is(equalTo(expectedAlbum)));
    }

    @Test
    void testUpdateAlbum() {
        Album expectedAlbum = Album.builder().name("Name").yearReleased(2022).build();
        expectedAlbum.setId(1);
        when(mockAlbumRepository.save(expectedAlbum)).thenReturn(expectedAlbum);
        when(mockAlbumRepository.findById(1L)).thenReturn(Optional.of(expectedAlbum));
        var actualAlbum = albumService.updateAlbum(expectedAlbum);
        assertThat(actualAlbum, is(equalTo(expectedAlbum)));
    }

    @Test
    void testDeleteAlbum() {
        doNothing().when(mockAlbumRepository).deleteById(1L);
        albumService.deleteAlbum(1);
        verify(mockAlbumRepository).deleteById(1L);
    }


    @Test
    void testDeleteAlbums() {
        doNothing().when(mockAlbumRepository).deleteAll();
        albumService.deleteAlbums();
        verify(mockAlbumRepository).deleteAll();
    }

    @Test
    void testGetAllAlbums() {
        List<Album> expectedAlbums = List.of(Album.builder().name("Name").yearReleased(2022).build());
        when(mockAlbumRepository.findAll()).thenReturn(expectedAlbums);
        var actualAlbums = albumService.getAllAlbums();
        assertThat(actualAlbums, is(equalTo(expectedAlbums)));
    }

    @Test
    void testGetAlbum() {
        List<Album> expectedAlbums = List.of(Album.builder().name("Name").yearReleased(2022).build());
        when(mockAlbumRepository.findByName("Name")).thenReturn(expectedAlbums);
        var actualAlbums = albumService.getAlbum("Name");
        assertThat(expectedAlbums, is(equalTo(actualAlbums)));
    }
}
