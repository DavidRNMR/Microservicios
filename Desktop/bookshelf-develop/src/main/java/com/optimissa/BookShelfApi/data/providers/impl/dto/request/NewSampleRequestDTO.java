package com.optimissa.BookShelfApi.data.providers.impl.dto.request;

import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewSampleRequestDTO {

    private String isbn;
    private long shopID;

}
