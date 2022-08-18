package com.optimissa.BookShelfApi.core.services;

import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;

import java.util.List;

/**
 * This class represents all the relevant methods to get information about Shop from the database.
 */
public interface IShopService {


    List<ShopResponseDTO> findAll ();

    ShopResponseDTO findShopByName(String name);

    ShopResponseDTO findShopById(long id);

    ShopResponseDTO addNewShop(ShopResponseDTO shop);

    ShopResponseDTO deleteShop(long id);


}



