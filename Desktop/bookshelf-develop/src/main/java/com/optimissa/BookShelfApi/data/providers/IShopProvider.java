package com.optimissa.BookShelfApi.data.providers;

import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;

import java.util.List;

/**
 * Show DATA methods to the outside world.
 */

public interface IShopProvider {

    ShopResponseDTO findById(Long id);
    ShopResponseDTO findByName(String name);
    ShopResponseDTO createShop(ShopResponseDTO shop);
    ShopResponseDTO deleteById(long id);
    List<ShopResponseDTO> findAll();

}
