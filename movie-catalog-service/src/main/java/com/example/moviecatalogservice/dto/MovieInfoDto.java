package com.example.moviecatalogservice.dto;

import jakarta.persistence.Column;
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

}
