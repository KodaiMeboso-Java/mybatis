package com.example.mybatis0603.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateName {
    @NotNull
    private int id;
    @NotBlank
    private String name;
}
