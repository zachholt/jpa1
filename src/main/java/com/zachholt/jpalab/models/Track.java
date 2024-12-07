package com.zachholt.jpalab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tracks")
public class Track {
    @Id
    @Column(name = "trackid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "albumid")
    private Integer albumId;

    @Column(name = "genreid")
    private Integer genreId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }
} 