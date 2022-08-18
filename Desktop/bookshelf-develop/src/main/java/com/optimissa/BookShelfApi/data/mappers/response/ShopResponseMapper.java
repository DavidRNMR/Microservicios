package com.optimissa.BookShelfApi.data.mappers.response;

import com.optimissa.BookShelfApi.data.entities.ShopModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Component that implements Imapper to map from a model (Entity) to a DTO
 */
@Component
public class ShopResponseMapper implements IMapper<ShopModel, ShopResponseDTO> {

    @Override
    public ShopResponseDTO mapToDto(ShopModel shopModel) {

        ShopResponseDTO dto = new ShopResponseDTO();
        dto.setId(shopModel.getId());
        dto.setName(shopModel.getName());
        dto.setCity(shopModel.getCity());
        dto.setDirection(shopModel.getDirection());

        return dto;
    }

    @Override
    public ShopModel mapToEntity(ShopResponseDTO shopResponseDTO) {
        return ShopModel.builder()
                .id(shopResponseDTO.getId())
                .name(shopResponseDTO.getName())
                .city(shopResponseDTO.getCity())
                .direction(shopResponseDTO.getDirection())
                .build();
    }
}
