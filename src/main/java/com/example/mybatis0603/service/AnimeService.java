package com.example.mybatis0603.service;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateForm;

import java.util.List;
public interface AnimeService {
    List<Name> findAll();

    List<Name> findById(int id);

    Name createName(CreateForm form);
}
