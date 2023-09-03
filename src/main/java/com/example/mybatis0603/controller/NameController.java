package com.example.mybatis0603.controller;

import com.example.mybatis0603.entity.Name;
import com.example.mybatis0603.exception.ResourceNotFoundException;
import com.example.mybatis0603.form.CreateForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.mybatis0603.service.AnimeService;

import java.net.URI;
import java.time.ZonedDateTime;
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

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {

        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "path", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
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
