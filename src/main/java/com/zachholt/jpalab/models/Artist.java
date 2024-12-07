package com.zachholt.jpalab.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "artists")
public class Artist {

    public Artist() {
    }

    public Artist(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "artistid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany (mappedBy = "artist")
    @JsonManagedReference
    private List<Album> albums;

    public Integer getId() {
        return id;
    }

    public Artist setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public Artist setAlbums(List<Album> albums) {
        this.albums = albums;
        return this;
    }
}