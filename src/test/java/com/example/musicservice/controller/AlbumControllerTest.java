package com.example.musicservice.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.model.Album;
import com.example.musicservice.service.AlbumService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AlbumControllerTest {

    @Mock
    private AlbumService mockAlbumService;

    @InjectMocks
    private AlbumController albumController;


    @Test
    void testSaveAlbum() {
        Album expectedAlbum = Album.builder().name("Name").yearReleased(2022).build();
        when(mockAlbumService.saveAlbum(expectedAlbum)).thenReturn(expectedAlbum);
        var actualAlbum = albumController.saveAlbum(expectedAlbum);
        assertThat(actualAlbum, is(equalTo(expectedAlbum)));
    }

    @Test
    void testUpdateAlbum() {
        Album expectedAlbum = Album.builder().name("Name").yearReleased(2022).build();
        when(mockAlbumService.updateAlbum(expectedAlbum)).thenReturn(expectedAlbum);
        var actualAlbum = albumController.updateAlbum(expectedAlbum);
        assertThat(actualAlbum, is(equalTo(expectedAlbum)));
    }

    @Test
    void testDeleteAlbum() {
        doNothing().when(mockAlbumService).deleteAlbum(1);
        albumController.deleteAlbum(1);
        verify(mockAlbumService).deleteAlbum(1);
    }


    @Test
    void testDeleteAlbums() {
        doNothing().when(mockAlbumService).deleteAlbums();
        albumController.deleteAlbums();
        verify(mockAlbumService).deleteAlbums();
    }

    @Test
    void testGetAllAlbums() {
        List<Album> expectedAlbums = List.of(Album.builder().name("Name").yearReleased(2022).build());
        when(mockAlbumService.getAllAlbums()).thenReturn(expectedAlbums);
        var actualAlbums = albumController.getAllAlbums();
        assertThat(actualAlbums, is(equalTo(expectedAlbums)));
    }

    @Test
    void testGetAlbum() {
        List<Album> expectedAlbums = List.of(Album.builder().name("Name").yearReleased(2022).build());
        when(mockAlbumService.getAlbum("Name")).thenReturn(expectedAlbums);
        var actualAlbums = albumController.getAlbum("Name");
        assertThat(expectedAlbums, is(equalTo(actualAlbums)));
    }
}
