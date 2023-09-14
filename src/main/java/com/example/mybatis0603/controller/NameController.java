package com.example.mybatis0603.controller;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.form.CreateName;
import com.example.mybatis0603.mapper.NameMapper;
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
    public final NameMapper nameMapper;

    public NameController(AnimeService animeService,NameMapper nameMapper) {
        this.animeService = animeService;
        this.nameMapper =nameMapper;
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
            @RequestBody @Validated CreateName createName, UriComponentsBuilder uriComponentsBuilder) {
        animeService.createName(createName);
        URI url = uriComponentsBuilder
                .path("/names/{id}")
                .buildAndExpand(createName.getId())
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PutMapping("/names/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody CreateName createName) {
        animeService.update(id, createName.getName());
        return ResponseEntity.ok("name successfully updated");
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        animeService.delete(id);
        return ResponseEntity.ok("name successfully deleted");
    }

}
