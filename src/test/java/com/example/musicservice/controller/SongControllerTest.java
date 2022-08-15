package com.example.musicservice.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.model.Song;
import com.example.musicservice.service.SongService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SongControllerTest {

    @Mock
    private SongService mockSongService;

    @InjectMocks
    private SongController songController;


    @Test
    void testSaveSong() {
        Song expectedSong = Song.builder().name("Name").track(1).build();
        when(mockSongService.saveSong(expectedSong)).thenReturn(expectedSong);
        var actualSong = songController.saveSong(expectedSong);
        assertThat(actualSong, is(equalTo(expectedSong)));
    }

    @Test
    void testUpdateSong() {
        Song expectedSong = Song.builder().name("Name").track(1).build();
        when(mockSongService.updateSong(expectedSong)).thenReturn(expectedSong);
        var actualSong = songController.updateSong(expectedSong);
        assertThat(actualSong, is(equalTo(expectedSong)));
    }

    @Test
    void testDeleteSong() {
        doNothing().when(mockSongService).deleteSong(1);
        songController.deleteSong(1);
        verify(mockSongService).deleteSong(1);
    }


    @Test
    void testDeleteAllSongs() {
        doNothing().when(mockSongService).deleteSongs();
        songController.deleteSongs();
        verify(mockSongService).deleteSongs();
    }

    @Test
    void testGetAllSongs() {
        List<Song> expectedSongs = List.of(Song.builder().name("Name").track(1).build());
        when(mockSongService.getAllSongs()).thenReturn(expectedSongs);
        var actualSongs = songController.getAllSongs();
        assertThat(actualSongs, is(equalTo(expectedSongs)));
    }

    @Test
    void testGetSong() {
        List<Song> expectedSongs = List.of(Song.builder().name("Name").track(1).build());
        when(mockSongService.getSong("Name")).thenReturn(expectedSongs);
        var actualSongs = songController.getSong("Name");
        assertThat(actualSongs, is(equalTo(expectedSongs)));
    }
}
