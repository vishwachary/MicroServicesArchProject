package com.example.moviecatalogservice.service;

import com.example.moviecatalogservice.dto.MovieInfoDto;
import com.example.moviecatalogservice.entity.MovieInfo;
import com.example.moviecatalogservice.repo.MovieCatalogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieCatalogService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieCatalogService.class);

    private final MovieCatalogRepository movieCatalogRepository;

    public MovieCatalogService(MovieCatalogRepository movieCatalogRepository) {
        this.movieCatalogRepository = movieCatalogRepository;
    }

    public List<MovieInfoDto> getAllMovieList()
    {   List<MovieInfo> allMovieList = movieCatalogRepository.findAll();
        LOGGER.info("Fetching all movies, total count: {}", allMovieList.size());
        List<MovieInfoDto> allMovieDtos = allMovieList.stream()
                .map(each -> mapEntity_to_Dto(each)).collect(Collectors.toList());
        return allMovieDtos;
    }

    private MovieInfoDto mapEntity_to_Dto(MovieInfo inputEntity)
    {
         return MovieInfoDto.builder().id(inputEntity.getId())
                 .movieName(inputEntity.getMovieName())
                 .movieDescription(inputEntity.getMovieDescription())
                 .rating(inputEntity.getRating()).build();
    }

    private MovieInfo  mapEntity_to_Dto(MovieInfoDto inputDto)
    {
        return MovieInfo.builder().id(inputDto.getId())
                .movieName(inputDto.getMovieName())
                .movieDescription(inputDto.getMovieDescription())
                .rating(inputDto.getRating()).build();
    }
}
