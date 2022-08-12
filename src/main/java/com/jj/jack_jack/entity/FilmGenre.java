package com.jj.jack_jack.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FilmGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Genre genre;

    @ManyToOne(optional = false)
    private Movie movie;

    public FilmGenre(Genre genre, Movie movie) {
        this.genre = genre;
        this.movie = movie;
    }

}
