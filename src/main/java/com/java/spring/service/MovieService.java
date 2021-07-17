package com.java.spring.service;

import com.java.spring.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    void deleteMovie(int id);

    Movie updateMovie(int id, Movie movie);

    Movie createMovie(Movie movie);

    Movie getMovieById(int id);
}
