package com.optimissa.BookShelfApi.data.providers.impl.dto.request;


import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@DTO
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OldSampleRequestDTO {

    public String isbn;
    public long shopId;
    public String description;
    public double price;
}
