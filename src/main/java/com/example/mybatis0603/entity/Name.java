package com.example.mybatis0603.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name {
    private int id;
    private String characterName;

    public Name(String characterName) {
        this.id = id;
        this.characterName = characterName;
    }
}
