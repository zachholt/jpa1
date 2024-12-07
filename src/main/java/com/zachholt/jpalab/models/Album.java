package com.zachholt.jpalab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "albums")
public class Album {
    @Id
    @Column(name = "albumid")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "artistid")
    private String artistid;

    public Integer getId() {
        return id;
    }

    public Album setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Album setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getArtistid() {
        return artistid;
    }

    public Album setArtistid(String artistid) {
        this.artistid = artistid;
        return this;
    }
}