package com.java.spring.validator;

import com.java.spring.entity.Movie;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Movie.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;
//        if (StringUtils.isBlank(movie.getTitle())) {
//            errors.rejectValue("title", "movie.title.capital-latter",
//                    "Movie title should not be blank!");
//        }
//
            if (StringUtils.isNotBlank(movie.getTitle()) && !CharUtils.isAsciiAlphaUpper(movie.getTitle().charAt(0))) {
            errors.rejectValue("title", "movie.title.capital-latter",
                    "Movie title should start with capital latter");
        }
    }
}
