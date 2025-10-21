package com.example.moviestreamingservice.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping ("/api/v1/movie-stream")
public class MovieStreamingController {

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
}
