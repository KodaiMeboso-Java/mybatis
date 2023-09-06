package com.example.mybatis0603.controller;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.mybatis0603.service.AnimeService;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {
    public final AnimeService animeService;

    public NameController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/names")
    public List<Name> names() {
        return animeService.findAll();
    }

    @GetMapping("/names/{id}")
    public Name selectOneName(@PathVariable("id") int id) {
        return animeService.findById(id);
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(
            @RequestBody @Validated CreateForm form, UriComponentsBuilder uriComponentsBuilder) {
        Name name = animeService.createName(form);
        URI url = uriComponentsBuilder
                .path("/names/" + name.getCharacterName())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

}
