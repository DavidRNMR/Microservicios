package com.optimissa.BookShelfApi.data.providers;

import com.optimissa.BookShelfApi.data.providers.impl.dto.response.AuthorResponseDTO;

import java.util.Collection;

/**
 * Show DATA methods to the front-end.
 */
public interface IAuthorProvider {

    AuthorResponseDTO getAuthorByName(String name);

    AuthorResponseDTO getAuthorById(Long id);

    Collection<AuthorResponseDTO> getAll();

    AuthorResponseDTO createAuthor(String authName);

    AuthorResponseDTO deleteAuthorById(Long id);
}
