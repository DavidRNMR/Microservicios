package com.optimissa.BookShelfApi.data.providers.impl.dto.request;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.*;

@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {

    public String mail;
    public String username;
    public String password;

}
