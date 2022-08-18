package com.optimissa.BookShelfApi.data.providers.impl.dto.response;


import com.optimissa.BookShelfApi.data.providers.impl.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This DTO contains the properties of the ShopModel object
 */

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopResponseDTO {

    public long id;
    public String name;
    public String city;
    public String direction;

}
