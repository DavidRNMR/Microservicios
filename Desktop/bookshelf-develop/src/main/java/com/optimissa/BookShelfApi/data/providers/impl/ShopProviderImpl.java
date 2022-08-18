package com.optimissa.BookShelfApi.data.providers.impl;
import com.optimissa.BookShelfApi.data.daos.IShopDao;
import com.optimissa.BookShelfApi.data.entities.ShopModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.IShopProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.error.ErrorFactoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopProviderImpl implements IShopProvider {

    private static final ErrorFactoryDTO<ShopResponseDTO> errorFactoryDTO = ErrorFactoryDTO.of(ShopResponseDTO.class);

    private final IShopDao dao;
    private final IMapper<ShopModel, ShopResponseDTO> mapper;

    @Override
    public ShopResponseDTO findById(Long id) {
        return dao.findById(id)
                .map(mapper::mapToDto)
                .orElse(errorFactoryDTO.error("No existe una tienda con ese ID"));
    }

    @Override
    public ShopResponseDTO findByName(String name) {
        ShopModel model = dao.findByName(name).orElse(null);
        if(model == null){
            return errorFactoryDTO.error("No existe ese nombre en la BBDD");
        }

        return mapper.mapToDto(model);
    }

    @Override
    public ShopResponseDTO createShop(ShopResponseDTO shop) {
        ShopModel model = mapper.mapToEntity(shop);
        if (!dao.existsById(model.getId()))
            return errorFactoryDTO.error("La tienda ya existe");

        dao.save(model);
        return shop;
    }

    @Override
    public ShopResponseDTO deleteById(long id) {
       ShopModel model = dao.findById(id).orElse(null);

        if(model == null)
            return errorFactoryDTO.error("El id no existe, no se puede borrar");

       ShopResponseDTO dto = mapper.mapToDto(model);
       dao.deleteById(id);

       return dto;
    }

    @Override
    public List<ShopResponseDTO> findAll() {
        return dao.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
}
