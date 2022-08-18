package com.optimissa.BookShelfApi.core.services;

import com.optimissa.BookShelfApi.data.providers.impl.dto.response.AuthorResponseDTO;

import java.util.List;

/**
 * This class represents all the relevant methods to get information about Author from the database.
 */
public interface IAuthorService {

    AuthorResponseDTO findAuthorByName(String name);

    AuthorResponseDTO findAuthorById(Long id);

    List<AuthorResponseDTO> findALL();

    AuthorResponseDTO addNewAuthor(String name);

    AuthorResponseDTO deleteAuthorById(Long id);

    
}
