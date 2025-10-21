package com.example.moviecatalogservice.repo;

import com.example.moviecatalogservice.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCatalogRepository extends JpaRepository<MovieInfo,Long> {
}
