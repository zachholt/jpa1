package com.zachholt.jpalab.controllers;

import com.zachholt.jpalab.models.Album;
import com.zachholt.jpalab.models.Artist;
import com.zachholt.jpalab.models.Track;
import com.zachholt.jpalab.services.AlbumService;
import com.zachholt.jpalab.services.ArtistService;
import com.zachholt.jpalab.services.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final TrackService trackService;

    public MusicController(AlbumService albumService, ArtistService artistService, TrackService trackService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.trackService = trackService;
    }

    @PostMapping("/albums/batch")
    public ResponseEntity<String> createAlbums() {
        artistService.createArtist(new Artist(100, "Architects"));
        artistService.createArtist(new Artist(101, "Lorna Shore"));
        artistService.createArtist(new Artist(102, "Machine Head"));
        artistService.createArtist(new Artist(103, "Oceans Ate Alaska"));
        artistService.createArtist(new Artist(104, "Revocation"));
        
        albumService.createAlbum(1, "The Classic Symptoms of a Broken Spirit", "arch1");
        albumService.createAlbum(2, "Pain Remains", "lorn1");
        albumService.createAlbum(3, "Of Kingdom and Crown", "mach1");
        albumService.createAlbum(4, "Disparity", "ocea1");
        albumService.createAlbum(5, "Netherheaven", "revo1");

        return ResponseEntity.ok("Albums created successfully");
    }

    @GetMapping("/tracks/genre/{genreId}")
    public ResponseEntity<List<Track>> getTracksByGenre(@PathVariable Integer genreId) {
        return ResponseEntity.ok(trackService.findByGenreId(genreId));
    }

    @GetMapping("/artists/{artistId}")
    public ResponseEntity<Artist> getArtistWithAlbums(@PathVariable Integer artistId) {
        return ResponseEntity.ok(albumService.getArtistWithAlbums(artistId));
    }

    @PostMapping("/artists")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artistData) {
        return ResponseEntity.ok(artistService.createArtist(artistData));
    }

    @PostMapping("/artists/{artistId}/albums")
    public ResponseEntity<String> addAlbumToArtist(@PathVariable String artistId, @RequestBody Map<String, String> albumData) {
        albumService.createAlbum(
            Integer.parseInt(albumData.get("id")), 
            albumData.get("title"), 
            artistId
        );
        return ResponseEntity.ok("Album added successfully");
    }
} 