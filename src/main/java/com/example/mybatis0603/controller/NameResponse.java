package com.example.mybatis0603.controller;

public class NameResponse {
    private int id;
    private String characterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return characterName;
    }

    public void setName(String name) {
        this.characterName = name;
    }
}
