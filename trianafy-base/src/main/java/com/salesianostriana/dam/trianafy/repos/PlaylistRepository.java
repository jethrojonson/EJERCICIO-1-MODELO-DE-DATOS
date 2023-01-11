package com.salesianostriana.dam.trianafy.repos;

import com.salesianostriana.dam.trianafy.model.Playlist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @EntityGraph("playlist-with-songs")
    Optional <Playlist> findById(Long id);

    @Query("""
            SELECT p FROM Playlist p LEFT JOIN FETCH p.songs s
            LEFT JOIN FETCH s.song s2 LEFT JOIN FETCH s2.artist ar
            WHERE ar.name = :name
            """)
    List<Playlist> findAllPlaylistOfAnArtist(String name);
}
