package com.java.spring.dao;

import com.java.spring.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerDao extends JpaRepository<Computer ,Integer> {
}
