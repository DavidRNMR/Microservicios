package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.ShopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * IShopDAO connects the DB(Shop) entity with the other DATA layers.
 */
@Repository
public interface IShopDao extends JpaRepository <ShopModel,Long> {

    void deleteById(long id);
    Optional<ShopModel> findByName(String name);



    
}
