package com.zachholt.jpalab.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.zachholt.jpalab.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO artists (artistid, name) VALUES (:id, :name)", nativeQuery = true)
    void insertArtist(@Param("id") String id, @Param("name") String name);
} 