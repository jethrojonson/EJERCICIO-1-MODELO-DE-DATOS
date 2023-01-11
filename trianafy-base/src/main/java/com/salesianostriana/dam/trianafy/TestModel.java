package com.salesianostriana.dam.trianafy;

import com.salesianostriana.dam.trianafy.model.AddedTo;
import com.salesianostriana.dam.trianafy.model.Artist;
import com.salesianostriana.dam.trianafy.model.Playlist;
import com.salesianostriana.dam.trianafy.model.Song;
import com.salesianostriana.dam.trianafy.repos.AddedToRepository;
import com.salesianostriana.dam.trianafy.repos.ArtistRepository;
import com.salesianostriana.dam.trianafy.repos.PlaylistRepository;
import com.salesianostriana.dam.trianafy.repos.SongRepository;
import com.salesianostriana.dam.trianafy.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestModel {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;
    private final PlaylistRepository playlistRepository;
    private final AddedToRepository addedToRepository;
    //*****************************//
    private final PlaylistService playlistService;

    @PostConstruct
    public void run() {

        Artist a1 = Artist.builder()
                .name("Violadores del verso")
                .build();

        Artist a2 = Artist.builder()
                .name("SFDK")
                .build();

        Artist a3 = Artist.builder()
                .name("Dogma Crew")
                .build();

        artistRepository.saveAll(List.of(a1,a2,a3));

        Song s1 = Song.builder()
                .title("Filosofía y letras")
                .album("Vivir para Contarlo")
                .artist(a1)
                .year("2002")
                .build();

        Song s2 = Song.builder()
                .title("Prúebalo")
                .album("Siempre Fuertes")
                .artist(a2)
                .year("2005")
                .build();

        Song s3 = Song.builder()
                .title("Antiheroe")
                .album("Nacen de la Bruma")
                .artist(a3)
                .year("2006")
                .build();

        songRepository.saveAll(List.of(s1, s2, s3));

        Playlist p1 = Playlist.builder()
                .name("Rap pal Body")
                .description("Lista de reproducción con Hip-Hoppity-Hop")
                .build();

        Playlist p2 = Playlist.builder()
                .name("Remix Inverso")
                .description("Lista de reproducción con Hip-Hoppity-Hop pero al réves")
                .build();

        playlistRepository.saveAll(List.of(p1));

        AddedTo add1 = AddedTo.builder()
                .song(s1)
                .playlist(p1)
                .datetime(LocalDateTime.now())
                .order(playlistRepository.findById(7L).get().getSongs().size() + 1)
                .build();

        addedToRepository.save(add1);

        AddedTo add2 = AddedTo.builder()
                .song(s2)
                .playlist(p1)
                .datetime(LocalDateTime.now())
                .order(playlistRepository.findById(7L).get().getSongs().size() + 1)
                .build();

        addedToRepository.save(add2);

        AddedTo add3 = AddedTo.builder()
                .song(s3)
                .playlist(p1)
                .datetime(LocalDateTime.now())
                .order(playlistRepository.findById(7L).get().getSongs().size() + 1)
                .build();

        addedToRepository.save(add3);

        playlistService.findById(7L).get().getSongs().forEach(s-> {
            if(s!=null)
                System.out.println("Cancion "+s.getOrder()+". "+s.getSong().getTitle()+" - "+s.getSong().getArtist().getName());
        });

        playlistRepository.findAllPlaylistOfAnArtist("SFDK").stream().forEach(s->{
            System.out.println(s.getId()+" "+s.getName()+" "+s.getDescription());
        });





    }

}
