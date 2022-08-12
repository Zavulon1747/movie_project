package com.jj.jack_jack.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "director")
    private String director;

    @Column(name = "country")
    private String country;

    @Column(name = "duration")
    private int duration;

    public Movie(String title, LocalDateTime releaseDate, String director, String country, int duration) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
        this.country = country;
        this.duration = duration;
    }

}
