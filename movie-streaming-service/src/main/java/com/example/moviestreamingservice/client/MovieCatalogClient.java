package com.example.moviestreamingservice.client;

import com.example.moviestreamingservice.dto.MovieInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-catalog-service")
public interface MovieCatalogClient {

    @GetMapping("/api/v1/movie-catalog/find-path-by-id/{movieinfoid}")
    MovieInfoDto getMoviePathById(@PathVariable("movieinfoid") Long movieinfoid);
}
