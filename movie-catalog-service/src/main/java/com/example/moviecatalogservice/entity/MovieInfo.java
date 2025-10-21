package com.example.moviecatalogservice.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MOVIE_NAME", nullable = false)
    private String movieName;

    @Column(name = "MOVIE_DESC", nullable = false)
    private String movieDescription ;


    @Column(name = "MOVIE_RATING",nullable = false)
    private Integer rating;


}
