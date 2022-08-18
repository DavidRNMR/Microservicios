package com.optimissa.BookShelfApi.core.controller;


import com.optimissa.BookShelfApi.data.providers.IBookProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Book Controller to be mirrored in the Swagger Iu
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    public IBookProvider bookProvider;



}
