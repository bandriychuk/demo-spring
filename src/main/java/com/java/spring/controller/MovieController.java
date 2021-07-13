package com.java.spring.controller;

import com.java.spring.entity.Movie;
import com.java.spring.service.MovieServiceImpl;
import com.java.spring.validator.MovieValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController// Щоб клас почав, хендлити реквести ставимо аннотацію @RestController
@RequiredArgsConstructor
public class MovieController {

    //Обєкти в Spring називаються Bean;

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private MovieValidator movieValidator;

    //    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @GetMapping(value = "/movie")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();

    }

    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
        return movieService.createMovie(movie);
        //Перед передачею обєкта на DAO обєкт повинен бути провалідований
    }

    @PutMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
//        final Optional<Movie> first = movies.stream()
//                .filter(m -> m.getId() == id)
//                .findFirst(); // - Шукаємо в стрімі, чи є обєкт з ід
//        final Movie movieInList =
//                first.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found")); // Якщо, немає ід тоді повертаємо 404
//
//        final int index = movies.indexOf(movieInList);
//        movie.setId(id);
//        movies.set(index, movie); // - Якщо, є ід тоді оновлюємо обєкт
//        return movie;
        return movieService.updateMovie(id, movie);

    }

    @DeleteMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable int id) {
//        final boolean isRemoved = movies.removeIf(movie -> movie.getId() == id);
//        if (isRemoved) {
//            System.out.println("Movie Removed");
//        } else {
//            System.out.println("No movie with such id");
//        }
        movieService.deleteMovie(id);
    }

    @InitBinder// Звязує наш контроллер з валідаторами
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators(movieValidator);
    }

    //Spring - бери валідатори з 2 місці 1 - де ми самі написали (initBinder), 2 - З класу де ми поставили різні аннотації


}
