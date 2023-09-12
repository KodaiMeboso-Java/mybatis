package com.example.mybatis0603.service;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateName;

import java.util.List;



public interface AnimeService {
    List<Name> findAll();

    Name findById(int id);

    void createName(CreateName createName);

    void update(int id, String name);
}
