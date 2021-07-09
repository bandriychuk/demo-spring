package com.java.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Car {
    private int id;
    private String name;
    private String model;
    private double engine;
    private int year;
}
