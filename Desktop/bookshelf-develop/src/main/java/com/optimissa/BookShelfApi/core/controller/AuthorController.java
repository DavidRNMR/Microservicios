package com.optimissa.BookShelfApi.core.controller;

import com.optimissa.BookShelfApi.core.services.IAuthorService;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.AuthorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Controller to be mirrored in the Swagger Iu
 */
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/allAuthors")
    public List<AuthorResponseDTO> getAll() {
        return authorService.findALL();
    }

    @GetMapping("/ByName/{name}")
    public AuthorResponseDTO getByName(@PathVariable String name) {
        return authorService.findAuthorByName(name);
    }

    @GetMapping("/ById/{id}")
    public AuthorResponseDTO getById(@PathVariable long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO createAuthor(@PathVariable String name) {
        return authorService.addNewAuthor(name);
    }

    @DeleteMapping("/delete/{id}")
    public AuthorResponseDTO deleteById(@PathVariable Long id) {
        return authorService.deleteAuthorById(id);
    }

}
