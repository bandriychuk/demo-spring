package com.java.spring.dao;

import com.java.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Integer> {
}
