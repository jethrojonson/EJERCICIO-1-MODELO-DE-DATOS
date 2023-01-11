package com.salesianostriana.dam.trianafy.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NamedEntityGraph(
        name = "playlist-with-songs",
        attributeNodes = {
                @NamedAttributeNode(
                        value = "songs",
                        subgraph = "playlist-with-song"
                )},
        subgraphs = {
                @NamedSubgraph(
                        name = "playlist-with-song",
                        attributeNodes = {
                                @NamedAttributeNode(
                                        value = "song",
                                        subgraph = "song-with-artist"
                                )
                        }
                ),
                @NamedSubgraph(
                        name = "song-with-artist",
                        attributeNodes = {
                                @NamedAttributeNode("artist")
                        }
                )
        }
)
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;


    @OneToMany(
            mappedBy = "playlist"
    )
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OrderColumn(name = "orden")
    private List<AddedTo> songs = new ArrayList<>();


}
