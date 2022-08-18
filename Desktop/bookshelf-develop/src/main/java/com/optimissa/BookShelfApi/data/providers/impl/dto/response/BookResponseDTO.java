package com.optimissa.BookShelfApi.data.providers.impl.dto.response;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO to use for generating a Book. The front-end must send an object like this.
 */
@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDTO {

    public String isbn;
    public String title;
    public String authorName;
    public String description;
    public LocalDate publication;
    public String editorial;
    public String family;
    public String language;
    public double price;
    public int stock;

}
