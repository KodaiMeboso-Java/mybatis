package com.example.mybatis0603.entity;

public class Name {
    private int id;
    private String characterName;

    public Name(String characterName) {
        this.id = id;
        this.characterName = characterName;
    }

    public int getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
