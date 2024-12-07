package com.zachholt.jpalab.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.zachholt.jpalab.models.Album;


public interface AlbumRepository extends JpaRepository<Album, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO albums (albumid, title, artistid) VALUES (:id, :title, :artistId)", nativeQuery = true)
    void insertAlbum(@Param("id") Integer id, @Param("title") String title, @Param("artistId") String artistId);

} 