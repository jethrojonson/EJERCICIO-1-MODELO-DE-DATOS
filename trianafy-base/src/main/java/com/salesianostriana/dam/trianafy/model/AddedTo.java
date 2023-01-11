package com.salesianostriana.dam.trianafy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class AddedTo {

    @EmbeddedId
    @Builder.Default
    private AddedToPk id = new AddedToPk();

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name= "songs")
    private Song song;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlists")
    private Playlist playlist;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime datetime;
    
    @Column(name = "orden")
    private int order;
}
