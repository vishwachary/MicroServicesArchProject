package com.example.moviecatalogservice.controller;

import com.example.moviecatalogservice.dto.MovieInfoDto;
import com.example.moviecatalogservice.service.MovieCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie-catalog")
public class MovieCatalogRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieCatalogRestController.class);

    private final MovieCatalogService movieCatalogService;

    public MovieCatalogRestController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    @GetMapping
    public ResponseEntity<List<MovieInfoDto>> getAllMovies() {
        List<MovieInfoDto> allMovieList = movieCatalogService.getAllMovieList();
        LOGGER.info("Fetching all movies, total count: {}", allMovieList.size());
        if(allMovieList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allMovieList);
    }
}
