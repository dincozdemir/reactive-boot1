package com.dinco.reactiveboot.component;

import com.dinco.reactiveboot.model.Movie;
import com.dinco.reactiveboot.repository.MovieRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
@Log
@Component
public class MovieDataCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    MovieDataCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        this.movieRepository
                .deleteAll()
                .subscribe(null, null, () ->
                        Stream.of("Flux Gordon", "Enter the Mono<Void>", "Back to the Future", "AEon Flux")
                                .map(title -> new Movie(title, UUID.randomUUID().toString()))
                                .forEach(movie -> movieRepository.save(movie).subscribe(m -> log.info(m.toString()))));
    }
}