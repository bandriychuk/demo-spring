package com.java.spring.service;

import com.java.spring.dao.ComputerDao;
import com.java.spring.entity.Computer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    private ComputerDao computerDao;


    @Override
    public List<Computer> getAllComputers() {
        return computerDao.findAll();
    }

    @Override
    public Computer createComputer(Computer computer) {
        return computerDao.saveAndFlush(computer);
    }

    @Override
    public Computer updateComputer(int id, Computer computer) {
        computer.setId(id);
        if (!computerDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No computer found");
        }
        return computerDao.saveAndFlush(computer);
    }



    @Override
    public void deleteComputer(int id) {
        if (!computerDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No computer found");
        }

        computerDao.deleteById(id);
    }
}
