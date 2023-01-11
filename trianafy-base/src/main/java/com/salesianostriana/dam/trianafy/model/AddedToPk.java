package com.salesianostriana.dam.trianafy.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddedToPk implements Serializable {

    private Long song_id;
    private Long playlist_id;


}
