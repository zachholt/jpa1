package com.zachholt.jpalab.services;

import com.zachholt.jpalab.models.Track;
import com.zachholt.jpalab.repos.TrackRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> findByGenreId(Integer genreId) {
        return trackRepository.findByGenreId(genreId);
    }
} 