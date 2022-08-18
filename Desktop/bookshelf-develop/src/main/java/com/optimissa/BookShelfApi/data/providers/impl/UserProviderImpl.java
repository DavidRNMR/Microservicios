package com.optimissa.BookShelfApi.data.providers.impl;

import com.optimissa.BookShelfApi.data.daos.IUserDao;
import com.optimissa.BookShelfApi.data.entities.UserModel;
import com.optimissa.BookShelfApi.data.entities.enums.UserRole;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.IUserProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.error.ErrorFactoryDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.request.UserRequestDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserProviderImpl implements IUserProvider {

    private static final String USER_MAIL_EXISTS = "user with mail %s already exists!";
    private static final String USER_USERNAME_EXISTS = "user with username %s";

    private final IUserDao userDao;
    private final IMapper<UserModel, UserRequestDTO> mapperRequest;
    private final IMapper<UserModel, UserResponseDTO> mapperResponse;
    private final PasswordEncoder encoder;

    @Override
    public UserResponseDTO getUserByMail(String mail) {
        return userDao.getByMail(mail)
                .map(mapperResponse::mapToDto)
                .orElse(null);
    }

    @Override
    public UserResponseDTO getUserByName(String username) {
        return userDao.getByUsername(username)
                .map(mapperResponse::mapToDto)
                .orElse(null);
    }

    @Override
    public UserResponseDTO register(UserRequestDTO dto) {
        if (userDao.getByMail(dto.mail).isPresent())
            return ErrorFactoryDTO.of(UserResponseDTO.class)
                    .error(String.format(USER_MAIL_EXISTS, dto.mail));

        if (userDao.getByUsername(dto.username).isPresent())
            return ErrorFactoryDTO.of(UserResponseDTO.class)
                    .error(String.format(USER_USERNAME_EXISTS, dto.username));

        UserModel user = mapperRequest.mapToEntity(dto);

        user.setPassword(encoder.encode(dto.password));
        user.setCreatedAt(LocalDateTime.now());
        user.setRole(UserRole.USER);

        userDao.save(user);

        return mapperResponse.mapToDto(user);
    }

}
