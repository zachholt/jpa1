package com.zachholt.jpalab.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zachholt.jpalab.models.Track;
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByGenreId(Integer genreId);
} 