package com.optimissa.BookShelfApi.core.controller;

import com.optimissa.BookShelfApi.core.services.IShopService;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Shop Controller to be mirrored in the Swagger Iu
 */
@RestController
@RequestMapping("/api/Shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @GetMapping("/allShops")
    public List<ShopResponseDTO> getAllShops(){ return shopService.findAll();}

    @GetMapping("/shopByName")
    public ShopResponseDTO getByName(String name){return shopService.findShopByName(name);}

    @GetMapping("/shopById")
    public ShopResponseDTO getById(long id){return shopService.findShopById(id);}


    @PostMapping("/addNewShop")
    public ShopResponseDTO addNewShop(ShopResponseDTO shop){return shopService.addNewShop(shop);}

    @DeleteMapping("/deleteShop")
    public ShopResponseDTO deleteShopById(long id){return shopService.deleteShop(id);}
    
}


