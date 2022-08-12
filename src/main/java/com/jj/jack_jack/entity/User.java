package com.jj.jack_jack.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    private String email;

    @JsonProperty(value = "favorite")
    @JsonManagedReference
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "user_favorite_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Movie> favoriteMovies = new HashSet<>();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "registered_date")
    private LocalDateTime registeredDate;

    private List<Comment> comments = new ArrayList<>();

    public User(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        registeredDate = LocalDateTime.now();
    }

}
