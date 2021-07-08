package com.java.spring.controller;

import com.java.spring.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController// Щоб клас почав, хендлити реквести ставимо аннотацію @RestController

public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie(1, "Start Wars: New Hope", 190));
        movies.add(new Movie(2, "LoTR: RoTK", 234));
    }

    //    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @GetMapping(value = "/movie")
    public List<Movie> getMovies() {
        return movies;
    }

    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody Movie movie) {
        movies.add(movie);
        return movie;
    }

    @PutMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        final Optional<Movie> first = movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst(); // - Шукаємо в стрімі, чи є обєкт з ід
        final Movie movieInList =
                first.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found")); // Якщо, немає ід тоді повертаємо 404

        final int index = movies.indexOf(movieInList);
        movie.setId(id);
        movies.set(index, movie); // - Якщо, є ід тоді оновлюємо обєкт
        return movie;
    }

    @DeleteMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
        final boolean isRemoved = movies.removeIf(movie -> movie.getId() == id);
        if (isRemoved) {
            System.out.println("Movie Removed");
        } else {
            System.out.println("No movie with such id");
        }
    }


}
