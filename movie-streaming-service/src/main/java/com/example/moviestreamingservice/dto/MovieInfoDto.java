package com.example.moviestreamingservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieInfoDto {
    private Long id;
    private String movieName;
    private String movieDescription;
    private Integer rating;
    private String path;

}
