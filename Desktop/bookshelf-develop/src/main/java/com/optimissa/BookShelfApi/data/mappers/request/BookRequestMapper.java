package com.optimissa.BookShelfApi.data.mappers.request;

import com.optimissa.BookShelfApi.data.entities.AuthorModel;
import com.optimissa.BookShelfApi.data.entities.BookDetailsModel;
import com.optimissa.BookShelfApi.data.entities.BookModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.request.BookRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class BookRequestMapper implements IMapper<BookModel, BookRequestDTO> {

    @Override
    public BookRequestDTO mapToDto(BookModel bookModel) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BookModel mapToEntity(BookRequestDTO bookRequestDTO) {
        BookDetailsModel bookDetailsModel = BookDetailsModel.builder()
                .description(bookRequestDTO.description)
                .family(bookRequestDTO.family)
                .price(bookRequestDTO.price)
                .editorial(bookRequestDTO.publisher)
                .publication(bookRequestDTO.publication)
                .language(bookRequestDTO.language)
                .build();

        return BookModel.builder()
                .id(bookRequestDTO.isbn)
                .title(bookRequestDTO.title)
                .bookDetails(bookDetailsModel)
                .build();
    }
}
