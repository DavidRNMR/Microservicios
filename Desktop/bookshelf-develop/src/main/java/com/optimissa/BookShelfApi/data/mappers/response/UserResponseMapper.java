package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.UserModel;
import com.optimissa.BookShelfApi.data.entities.enums.UserRole;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.response.UserResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserResponseMapper implements IMapper<UserModel, UserResponseDTO> {

    @Override
    public UserResponseDTO mapToDto(UserModel userModel) {
        return new UserResponseDTO(
                userModel.getMail(),
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getRole().name(),
                userModel.getCreatedAt(),
                userModel.isLocked(),
                userModel.isEnabled()
        );
    }

    @Override
    public UserModel mapToEntity(UserResponseDTO userResponseDTO) {
        return UserModel.builder()
                .mail(userResponseDTO.mail)
                .username(userResponseDTO.username)
                .password(userResponseDTO.password)
                .role(UserRole.valueOf(userResponseDTO.role))
                .createdAt(userResponseDTO.createdAt)
                .locked(userResponseDTO.locked)
                .enabled(userResponseDTO.enabled)
                .build();
    }
}
