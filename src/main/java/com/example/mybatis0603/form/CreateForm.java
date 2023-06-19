package com.example.mybatis0603.form;

import jakarta.validation.constraints.NotBlank;

public class CreateForm {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
