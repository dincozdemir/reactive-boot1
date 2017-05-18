package com.dinco.reactiveboot.repository;

import com.dinco.reactiveboot.model.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Dinco-WORK on 19.05.2017.
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}