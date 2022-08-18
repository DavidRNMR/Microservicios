package com.optimissa.BookShelfApi.data.providers.impl.dto.response;

import com.optimissa.BookShelfApi.data.entities.BookModel;
import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * DTO to use for generating a author. The front-end must send an object like this.
 */

@DTO
@Data
@NoArgsConstructor
public class AuthorResponseDTO {

    public long id;
    public String name;
    public Set<BookModel> books;
}
