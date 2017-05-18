package com.dinco.reactiveboot.service;

import com.dinco.reactiveboot.model.Movie;
import com.dinco.reactiveboot.model.MovieEvent;
import com.dinco.reactiveboot.repository.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
@Service
public class FluxFlixService {

    private final MovieRepository movieRepository;

    FluxFlixService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flux<MovieEvent> streamStreams(String movieId) {
        return byId(movieId).flatMapMany(movie -> {

            Flux<MovieEvent> eventFlux = Flux.fromStream(
                    Stream.generate(() -> new MovieEvent(movie, new Date(), randomUser())));

            Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

            return Flux.zip(eventFlux, interval).map(Tuple2::getT1);
        });
    }

    private String randomUser() {
        String users[] = "dsyer,sdeleuze,mkheck,jlong".split(",");
        return users[new Random().nextInt(users.length)];
    }

    public Flux<Movie> all() {
        return movieRepository.findAll();
    }

    public Mono<Movie> byId(String id) {
        return movieRepository.findById(id);
    }
}