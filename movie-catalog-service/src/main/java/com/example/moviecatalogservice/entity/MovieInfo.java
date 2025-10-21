package com.example.moviecatalogservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_INFO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MOVIE_NAME", nullable = false)
    private String movieName;

    @Column(name = "MOVIE_DESC", nullable = false)
    private String movieDescription;


    @Column(name = "MOVIE_RATING", nullable = false)
    private Integer rating;

    @Column(name = "MOVIE_PATH", nullable = false)
    private String path;
}
