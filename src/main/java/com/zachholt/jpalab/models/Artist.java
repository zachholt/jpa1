package com.zachholt.jpalab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "artists")
public class Artist {
    @Id
    @Column(name = "artistid")
    private String id;

    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public Artist setId(String id) {
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
}