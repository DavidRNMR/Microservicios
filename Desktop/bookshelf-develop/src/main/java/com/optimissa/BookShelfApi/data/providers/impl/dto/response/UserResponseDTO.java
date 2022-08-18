package com.optimissa.BookShelfApi.data.providers.impl.dto.response;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO  {

    public String mail;
    public String username;
    public String password;
    public String role;
    public LocalDateTime createdAt;
    public boolean locked;
    public boolean enabled;

}
