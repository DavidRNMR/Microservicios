package com.optimissa.BookShelfApi.core.services.impl;

import com.optimissa.BookShelfApi.core.services.IAuthorService;
import com.optimissa.BookShelfApi.data.providers.impl.AuthorProviderImpl;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.AuthorResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorProviderImpl authorProvider;

    public AuthorResponseDTO findAuthorByName(String name) {
        return authorProvider.getAuthorByName(name);
    }

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        return authorProvider.getAuthorById(id);
    }

    @Override
    public List<AuthorResponseDTO> findALL() {
        return (List<AuthorResponseDTO>) authorProvider.getAll();
    }

    @Override
    public AuthorResponseDTO addNewAuthor(String name) {
        return authorProvider.createAuthor(name);
    }

    @Override
    public AuthorResponseDTO deleteAuthorById(Long id) {
        return authorProvider.deleteAuthorById(id);
    }


}
