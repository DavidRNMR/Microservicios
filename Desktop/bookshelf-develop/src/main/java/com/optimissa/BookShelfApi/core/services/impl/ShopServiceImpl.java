package com.optimissa.BookShelfApi.core.services.impl;

import com.optimissa.BookShelfApi.core.services.IShopService;
import com.optimissa.BookShelfApi.data.providers.impl.ShopProviderImpl;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class implements the methods defined in IShopService
 */
@Service
@AllArgsConstructor
public class ShopServiceImpl implements IShopService {

    private final ShopProviderImpl shopProvider;


    @Override
    public List<ShopResponseDTO> findAll() {
        return shopProvider.findAll();
    }

    @Override
    public ShopResponseDTO findShopByName(String name) {
        return shopProvider.findByName(name);
    }

    @Override
    public ShopResponseDTO findShopById(long id) {
        return shopProvider.findById(id);
    }

    @Override
    public ShopResponseDTO addNewShop(ShopResponseDTO shop) {
        return shopProvider.createShop(shop);
    }

    @Override
    public ShopResponseDTO deleteShop(long id) {
        return shopProvider.deleteById(id);
    }
}

