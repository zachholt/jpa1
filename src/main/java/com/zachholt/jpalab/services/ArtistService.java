package com.zachholt.jpalab.services;

import com.zachholt.jpalab.models.Artist;
import com.zachholt.jpalab.repos.AlbumRepository;
import com.zachholt.jpalab.repos.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public ArtistService(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    public Artist createArtist(Artist artist) {
        artistRepository.save(artist);
        albumRepository.saveAll(artist.getAlbums());
        return artistRepository.findById(artist.getId()).get();
    }

    public Artist getArtist(Integer artistId) {
        return artistRepository.findById(artistId)
            .orElseThrow(() -> new RuntimeException("Artist not found"));
    }
} 