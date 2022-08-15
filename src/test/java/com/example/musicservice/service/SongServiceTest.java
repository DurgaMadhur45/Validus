package com.example.musicservice.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.dao.SongRepository;
import com.example.musicservice.model.Song;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SongServiceTest {

    @Mock
    private SongRepository mockSongRepository;

    @InjectMocks
    private SongService songService;


    @Test
    void testSaveSong() {
        Song expectedSong = Song.builder().name("Name").track(1).build();
        when(mockSongRepository.save(expectedSong)).thenReturn(expectedSong);
        var actualSong = songService.saveSong(expectedSong);
        assertThat(actualSong, is(equalTo(expectedSong)));
    }

    @Test
    void testUpdateSong() {
        Song expectedSong = Song.builder().name("Name").track(1).build();
        expectedSong.setId(1);
        when(mockSongRepository.save(expectedSong)).thenReturn(expectedSong);
        when(mockSongRepository.findById(1L)).thenReturn(Optional.of(expectedSong));
        var actualSong = songService.updateSong(expectedSong);
        assertThat(actualSong, is(equalTo(expectedSong)));
    }

    @Test
    void testDeleteSong() {
        doNothing().when(mockSongRepository).deleteById(1L);
        songService.deleteSong(1);
        verify(mockSongRepository).deleteById(1L);
    }


    @Test
    void testDeleteAllSongs() {
        doNothing().when(mockSongRepository).deleteAll();
        songService.deleteSongs();
        verify(mockSongRepository).deleteAll();
    }

    @Test
    void testGetAllSongs() {
        List<Song> expectedSongs = List.of(Song.builder().name("Name").track(1).build());
        when(mockSongRepository.findAll()).thenReturn(expectedSongs);
        var actualSongs = songService.getAllSongs();
        assertThat(actualSongs, is(equalTo(expectedSongs)));
    }

    @Test
    void testGetSong() {
        List<Song> expectedSongs = List.of(Song.builder().name("Name").track(1).build());
        when(mockSongRepository.findByName("Name")).thenReturn(expectedSongs);
        var actualSongs = songService.getSong("Name");
        assertThat(actualSongs, is(equalTo(expectedSongs)));
    }
}
