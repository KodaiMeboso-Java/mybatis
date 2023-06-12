package com.example.mybatis0603.controller;

import com.example.mybatis0603.NameMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NameController {
    public final NameMapper nameMapper;

    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names")
    public List<Name> names() {
        return nameMapper.findAll();
    }

    @GetMapping("/names/{id}")
    public Optional<Name> selectOneName(@PathVariable int id) {
        return nameMapper.findById(id);
    }

    @PostMapping("/create")
    public String createName(){
        final  var name = nameMapper.insert("式守都");
        System.out.println(name);
        return "creataName";
    }
}
