package com.optimissa.BookShelfApi.data.mappers.request;

import com.optimissa.BookShelfApi.data.entities.UserModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.request.UserRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserRequestMapper implements IMapper<UserModel, UserRequestDTO> {

    @Override
    public UserRequestDTO mapToDto(UserModel user) {
        return new UserRequestDTO(user.getMail(),
                user.getMail(),
                user.getPassword()
        );
    }

    @Override
    public UserModel mapToEntity(UserRequestDTO userDTO) {
        return UserModel.builder()
                .mail(userDTO.mail)
                .username(userDTO.username)
                .password(userDTO.password)
                .build();
    }

}
