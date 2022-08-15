package com.example.musicservice.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.musicservice.model.Artist;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArtistControllerTest {

    @Mock
    private com.example.musicservice.service.ArtistService mockArtistService;

    @InjectMocks
    private ArtistController artistController;


    @Test
    void testSaveArtist() {
        Artist expectedArtist = Artist.builder().name("Name").build();
        when(mockArtistService.saveArtist(expectedArtist)).thenReturn(expectedArtist);
        var actualArtist = artistController.saveArtist(expectedArtist);
        assertThat(actualArtist, is(equalTo(expectedArtist)));
    }

    @Test
    void testUpdateArtist() {
        Artist expectedArtist = Artist.builder().name("Name").build();
        when(mockArtistService.updateArtist(expectedArtist)).thenReturn(expectedArtist);
        var actualArtist = artistController.updateArtist(expectedArtist);
        assertThat(actualArtist, is(equalTo(expectedArtist)));
    }

    @Test
    void testDeleteArtist() {
        doNothing().when(mockArtistService).deleteArtist(1);
        artistController.deleteArtist(1);
        verify(mockArtistService).deleteArtist(1);
    }


    @Test
    void testDeleteAllArtists() {
        doNothing().when(mockArtistService).deleteAllArtists();
        artistController.deleteAllArtists();
        verify(mockArtistService).deleteAllArtists();
    }

    @Test
    void testGetAllArtists() {
        List<Artist> expectedArtists = List.of(Artist.builder().name("Name").build());
        when(mockArtistService.getAllArtists()).thenReturn(expectedArtists);
        var actualArtists = artistController.getAllArtists();
        assertThat(actualArtists, is(equalTo(expectedArtists)));
    }

    @Test
    void testGetArtist() {
        List<Artist> expectedArtists = List.of(Artist.builder().name("Name").build());
        when(mockArtistService.getArtist("Name")).thenReturn(expectedArtists);
        var actualArtists = artistController.getArtist("Name");
        assertThat(actualArtists, is(equalTo(expectedArtists)));
    }
}
