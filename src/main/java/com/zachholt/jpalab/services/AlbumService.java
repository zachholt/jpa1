package com.zachholt.jpalab.services;

import com.zachholt.jpalab.models.Album;
import com.zachholt.jpalab.models.Artist;
import com.zachholt.jpalab.repos.AlbumRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;

    public AlbumService(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    public void createAlbum(Integer id, String title, String artistId) {
        albumRepository.insertAlbum(id, title, artistId);
    }

    public Artist getArtistWithAlbums(Integer artistId) {
        Artist artist = artistService.getArtist(artistId);
        return artist;
    }
} 