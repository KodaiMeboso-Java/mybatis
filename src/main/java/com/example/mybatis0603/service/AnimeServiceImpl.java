package com.example.mybatis0603.service;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.exception.ResourceNotFoundException;
import com.example.mybatis0603.form.CreateName;
import com.example.mybatis0603.mapper.NameMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimeServiceImpl implements AnimeService {
    NameMapper nameMapper;

    public AnimeServiceImpl(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findAll() {
        return nameMapper.findAll();
    }

    @Override
    public Name findById(int id) {
        Optional<Name> name = this.nameMapper.findById(id);
        return name.orElseThrow(() -> new ResourceNotFoundException("名前が見つかりません！"));
    }

    @Override
    public void createName(CreateName createName) {
        nameMapper.createName(createName);
    }

    @Override
    public void update(int id, String name) {
        findById(id);
        nameMapper.update(id, name);
    }

    @Override
    public void delete(int id) {
        findById(id);
        nameMapper.delete(id);
    }

}
