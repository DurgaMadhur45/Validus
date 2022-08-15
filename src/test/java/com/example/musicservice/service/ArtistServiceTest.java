package com.example.musicservice.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.dao.ArtistRepository;
import com.example.musicservice.model.Album;
import com.example.musicservice.model.Artist;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository mockArtistRepository;

    @InjectMocks
    private ArtistService artistService;


    @Test
    void testSaveArtist() {
        Artist expectedArtist = Artist.builder().name("Name").build();
        when(mockArtistRepository.save(expectedArtist)).thenReturn(expectedArtist);
        var actualArtist = artistService.saveArtist(expectedArtist);
        assertThat(actualArtist, is(equalTo(expectedArtist)));
    }

    @Test
    void testUpdateArtist() {
        Artist expectedArtist = Artist.builder().name("Name").build();
        expectedArtist.setId(1);
        when(mockArtistRepository.save(expectedArtist)).thenReturn(expectedArtist);
        when(mockArtistRepository.findById(1L)).thenReturn(Optional.of(expectedArtist));
        var actualArtist = artistService.updateArtist(expectedArtist);
        assertThat(actualArtist, is(equalTo(expectedArtist)));
    }

    @Test
    void testDeleteArtist() {
        doNothing().when(mockArtistRepository).deleteById(1L);
        artistService.deleteArtist(1);
        verify(mockArtistRepository).deleteById(1L);
    }


    @Test
    void testDeleteAllArtists() {
        doNothing().when(mockArtistRepository).deleteAll();
        artistService.deleteAllArtists();
        verify(mockArtistRepository).deleteAll();
    }

    @Test
    void testGetAllArtists() {
        List<Artist> expectedArtists = List.of(Artist.builder().name("Name").build());
        when(mockArtistRepository.findAll()).thenReturn(expectedArtists);
        var actualArtists = artistService.getAllArtists();
        assertThat(actualArtists, is(equalTo(expectedArtists)));
    }

    @Test
    void testGetArtist() {
        List<Artist> expectedArtists = List.of(Artist.builder().name("Name").build());
        when(mockArtistRepository.findByName("Name")).thenReturn(expectedArtists);
        var actualArtists = artistService.getArtist("Name");
        assertThat(actualArtists, is(equalTo(expectedArtists)));
    }
}
