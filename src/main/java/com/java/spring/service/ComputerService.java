package com.java.spring.service;

import com.java.spring.entity.Computer;

import java.util.List;

public interface ComputerService {

    List<Computer> getAllComputers();

    void deleteComputer(int id);

    Computer updateComputer(int id, Computer computer);

    Computer createComputer(Computer computer);
}
