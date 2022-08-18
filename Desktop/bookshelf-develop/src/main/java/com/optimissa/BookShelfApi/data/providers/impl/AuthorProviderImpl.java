package com.optimissa.BookShelfApi.data.providers.impl;

import com.optimissa.BookShelfApi.data.daos.IAuthorDao;
import com.optimissa.BookShelfApi.data.entities.AuthorModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.IAuthorProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.AuthorResponseDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.error.ErrorFactoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorProviderImpl implements IAuthorProvider {

    private final IAuthorDao auDao;
    private final IMapper<AuthorModel, AuthorResponseDTO> mapper;

    @Override
    public AuthorResponseDTO getAuthorByName(String name) {
        return auDao.findByName(name)
                .map(mapper::mapToDto)
                .orElse(ErrorFactoryDTO.of(AuthorResponseDTO.class).error("Autor no encontrado"));
    }

    public AuthorResponseDTO getAuthorById(Long id) {
        return auDao.findById(id)
                .map(mapper::mapToDto)
                .orElse(ErrorFactoryDTO.of(AuthorResponseDTO.class).error("Autor no encontrado"));
    }

    public Collection<AuthorResponseDTO> getAll() {
        return auDao.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }


    public AuthorResponseDTO createAuthor(String authDt) {
        if (auDao.findByName(authDt).isPresent())
            ErrorFactoryDTO.of(AuthorResponseDTO.class).error("Ya existe un autor con ese nombre");

        AuthorModel authMod = AuthorModel.builder()
                .name(authDt)
                .build();

        authMod = auDao.save(authMod);

        return mapper.mapToDto(authMod);
    }

    public AuthorResponseDTO deleteAuthorById(Long id) {

        AuthorModel author = auDao.findById(id).orElse(null);

        if (author==null)
            ErrorFactoryDTO.of(AuthorResponseDTO.class).error("Error al eliminar el autor");

        auDao.deleteById(id);

        return mapper.mapToDto(author);
    }

}
