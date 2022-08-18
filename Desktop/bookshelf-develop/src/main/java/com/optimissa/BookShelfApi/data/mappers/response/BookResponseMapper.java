package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.BookModel;
import com.optimissa.BookShelfApi.data.entities.SampleModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.response.BookResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class BookResponseMapper implements IMapper<BookModel, BookResponseDTO> {

    @Override
    public BookResponseDTO mapToDto(BookModel model) {
        return BookResponseDTO.builder()
                .isbn(model.getId())
                .authorName(model.getAuthor().getName())
                .title(model.getTitle())
                .description(model.getBookDetails().getDescription())
                .publication(model.getBookDetails().getPublication())
                .family(model.getBookDetails().getFamily())
                .editorial(model.getBookDetails().getEditorial())
                .language(model.getBookDetails().getLanguage())
                .price(model.getBookDetails().getPrice())
                .stock(getStock(model))
                .build();
    }

    private int getStock(BookModel model) {
        if (model.getSamples() == null)
            return 0;

        return (int) model.getSamples().stream()
                .filter(SampleModel::isNew)
                .count();
    }

    @Override
    public BookModel mapToEntity(BookResponseDTO bookResponseDTO) {
        throw new UnsupportedOperationException();
    }
}
