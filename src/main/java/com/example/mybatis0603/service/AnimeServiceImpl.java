package com.example.mybatis0603.service;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateForm;
import com.example.mybatis0603.mapper.NameMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServiceImpl implements AnimeService{
    private final NameMapper nameMapper;

    public AnimeServiceImpl(NameMapper nameMapper){
        this.nameMapper=nameMapper;
    }

    public List<Name> findAll(){
        return nameMapper.findAll();
    }


    public Optional<Name> findById(int id) {
        return nameMapper.findById(id);
    }

    @Override
    public Name createName(CreateForm form) {
        return null;
    }

    public Name createForm(CreateForm createForm){
        Name name = new Name(createForm.getName());
        nameMapper.createName(name);
        return name;
    }
}
