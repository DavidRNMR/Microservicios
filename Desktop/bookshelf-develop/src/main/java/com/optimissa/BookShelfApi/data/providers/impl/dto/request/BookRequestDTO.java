package com.optimissa.BookShelfApi.data.providers.impl.dto.request;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * This class is a DTO that uses the attributes of bookModel that you are interested in.
 */
@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDTO {

    public String isbn;
    public String title;
    public String publisher;
    public String author;
    public String description;
    public String family;
    public LocalDate publication;
    public double price;
    public String language;

}
