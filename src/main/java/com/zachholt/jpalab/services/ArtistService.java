package com.zachholt.jpalab.services;

import com.zachholt.jpalab.models.Artist;
import com.zachholt.jpalab.repos.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist createArtist(String id, String name) {
        Artist artist = new Artist();
        artist.setId(id);
        artist.setName(name);
        return artistRepository.save(artist);
    }

    public Artist getArtist(String artistId) {
        return artistRepository.findById(artistId)
            .orElseThrow(() -> new RuntimeException("Artist not found"));
    }
} 