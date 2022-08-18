package com.optimissa.BookShelfApi.data.providers.impl.dto.response;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO to use for generating a OldBook. The front-end must send an object like this.
 */
@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OldBookResponseDTO {

    public long id;
    public String isbn;
    public String title;
    public String editorial;
    public String authorName;
    public String description;
    public LocalDate publication;
    public String language;
    public String family;
    public String status;
    public double price;

}
