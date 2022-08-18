package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.RentBookModel;
import com.optimissa.BookShelfApi.data.entities.SampleModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.dto.response.OldBookResponseDTO;
import com.optimissa.BookShelfApi.dto.response.RentedBookResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RentedBookResponseMapper implements IMapper<RentBookModel, RentedBookResponseDTO> {

    private IMapper<SampleModel, OldBookResponseDTO> oldBookMapper;

    @Override
    public RentedBookResponseDTO mapToDto(RentBookModel rentBookModel) {
        return RentedBookResponseDTO.builder()
                .username(rentBookModel.getUser().getUsername())
                .startDate(rentBookModel.getStartDate())
                .endDate(rentBookModel.getEndDate())
                .rentedBook(oldBookMapper.mapToDto(rentBookModel.getSample()))
                .build();
    }

    @Override
    public RentBookModel mapToEntity(RentedBookResponseDTO rentedBookResponseDTO) {
        throw new UnsupportedOperationException();
    }
}
