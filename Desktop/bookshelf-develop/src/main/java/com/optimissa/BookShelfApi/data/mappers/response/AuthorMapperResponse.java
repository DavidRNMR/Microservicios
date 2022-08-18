package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.AuthorModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.response.AuthorResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthorMapperResponse implements IMapper<AuthorModel, AuthorResponseDTO> {

    @Override
    public AuthorResponseDTO mapToDto(AuthorModel authorModel) {

        AuthorResponseDTO Adto = new AuthorResponseDTO();
        Adto.setId(authorModel.getId());
        Adto.setName(authorModel.getName());
        Adto.setBooks(authorModel.getBooks());

        return Adto;
    }

    @Override
    public AuthorModel mapToEntity(AuthorResponseDTO authorResponseDTO) {

        AuthorModel authM = new AuthorModel();
        authM.setId(authorResponseDTO.getId());
        authM.setName(authorResponseDTO.getName());
        authM.setBooks(authorResponseDTO.getBooks());

        return authM;
    }
}
