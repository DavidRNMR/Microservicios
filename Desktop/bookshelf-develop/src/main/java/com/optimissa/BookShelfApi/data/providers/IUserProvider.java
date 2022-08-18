package com.optimissa.BookShelfApi.data.providers;

import com.optimissa.BookShelfApi.data.providers.impl.dto.request.UserRequestDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.UserResponseDTO;

/**
 * Show DATA methods to the front-end.
 */
public interface IUserProvider {

    UserResponseDTO getUserByMail(String mail);

    UserResponseDTO getUserByName(String username);

    UserResponseDTO register(UserRequestDTO dto);

}
