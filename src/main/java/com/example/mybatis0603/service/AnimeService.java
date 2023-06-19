package com.example.mybatis0603.service;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateForm;

import java.util.List;
import java.util.Optional;

public interface AnimeService {
    List<Name> findAll();
    Optional<Name> findById(int id);
    Name createName(CreateForm form);
}
