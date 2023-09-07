package com.example.mybatis0603.form;

import jakarta.validation.constraints.NotBlank;

public class CreateForm {
    @NotBlank
    private String charactername;

    public String getName() {
        return charactername;
    }

    public void setName(String name) {
        this.charactername = name;
    }
}
