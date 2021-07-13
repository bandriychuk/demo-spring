package com.java.spring.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "MOVIE_TABLE") // - @Table - дозволяє створити таблицю з іменем яке нам потрібно
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    @NotBlank
    private String title;
    @Positive
    private int duration;

    public String getTitle() {
        return title;
    }

    public String setTitle() {
        return this.title = title;
    }


}
