package com.example.moviestreamingservice.controller;

import com.example.moviestreamingservice.client.MovieCatalogClient;
import com.example.moviestreamingservice.dto.MovieInfoDto;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping ("/api/v1/movie-stream")
public class MovieStreamingController {

    private final MovieCatalogClient movieCatalogClient;
    public MovieStreamingController(MovieCatalogClient movieCatalogClient) {
        this.movieCatalogClient = movieCatalogClient;
    }

    String VIDEO_URL = "D:\\softwares\\sample_video_streams\\";

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideoz(@PathVariable String videoPath) throws FileNotFoundException {
          File file = new File(VIDEO_URL+videoPath);
        if (file.exists()) {
            try {
                InputStreamResource videoStream = new InputStreamResource(new FileInputStream(file));

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + file.getName())
                        .contentType(MediaTypeFactory.getMediaType(file.getName()).orElse(MediaType.APPLICATION_OCTET_STREAM))
                        .contentLength(file.length())
                        .body(videoStream);

            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/stream/with-id/{videoId}")
    public ResponseEntity<InputStreamResource> streamVideozById(@PathVariable Long videoId) throws FileNotFoundException {

        MovieInfoDto moviePathById = movieCatalogClient.getMoviePathById(videoId);
        File file = new File(VIDEO_URL+moviePathById.getPath());
        if (file.exists()) {
            try {
                InputStreamResource videoStream = new InputStreamResource(new FileInputStream(file));

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + file.getName())
                        .contentType(MediaTypeFactory.getMediaType(file.getName()).orElse(MediaType.APPLICATION_OCTET_STREAM))
                        .contentLength(file.length())
                        .body(videoStream);

            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
