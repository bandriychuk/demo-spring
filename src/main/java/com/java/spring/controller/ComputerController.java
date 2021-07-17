package com.java.spring.controller;

import com.java.spring.entity.Computer;
import com.java.spring.service.ComputerServiceImpl;
import com.java.spring.validator.ComputerValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private final ComputerServiceImpl computerService;

    @Autowired
    private final ComputerValidator computerValidator;

    @GetMapping
    public List<Computer> getComputers(){
        return computerService.getAllComputers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Computer insertComputer(@RequestBody @Valid Computer computer){
        return computerService.createComputer(computer);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Computer updateComputer(@PathVariable int id, @RequestBody Computer computer){
        return computerService.updateComputer(id,computer);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComputer(@PathVariable int id){
        computerService.deleteComputer(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
    dataBinder.addValidators(computerValidator);
    }
}
