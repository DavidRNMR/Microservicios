package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.SampleModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.response.OldBookResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OldBookResponseMapper implements IMapper<SampleModel, OldBookResponseDTO> {

    @Override
    public OldBookResponseDTO mapToDto(SampleModel sampleModel) {

        return OldBookResponseDTO.builder()
                .isbn(sampleModel.getBook().getId())
                .title(sampleModel.getBook().getTitle())
                .editorial(sampleModel.getBook().getBookDetails().getEditorial())
                .authorName(sampleModel.getBook().getAuthor().getName())
                .description(sampleModel.getBook().getBookDetails().getDescription())
                .publication(sampleModel.getBook().getBookDetails().getPublication())
                .language(sampleModel.getBook().getBookDetails().getLanguage())
                .family(sampleModel.getBook().getBookDetails().getFamily())
                .price(sampleModel.getBook().getBookDetails().getPrice())
                .status(sampleModel.getBrokenDetails().getStatus())
                .build();

    }

    @Override
    public SampleModel mapToEntity(OldBookResponseDTO oldBookResponseDTO) {
        throw new UnsupportedOperationException();
    }


}
