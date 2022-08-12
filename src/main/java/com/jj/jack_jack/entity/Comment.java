package com.jj.jack_jack.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "content", nullable = false)
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "registered_date")
    private LocalDateTime createdDate;

    @Column(name = "spoiler", nullable = false)
    private boolean spoiler;

    @Column(name = "likes", nullable = false)
    private int likes;

    @Column(name = "dislikes", nullable = false)
    private int dislikes;

    public Comment(Movie movie, User user, String content, boolean spoiler) {
        this.movie = movie;
        this.user = user;
        this.content = content;
        this.spoiler = spoiler;
        createdDate = LocalDateTime.now();
    }

}
