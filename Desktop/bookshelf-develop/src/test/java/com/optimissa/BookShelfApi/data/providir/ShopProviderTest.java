package com.optimissa.BookShelfApi.data.providir;

import com.optimissa.BookShelfApi.data.providers.IShopProvider;
import com.optimissa.BookShelfApi.data.providers.impl.ShopProviderImpl;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.ShopResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShopProviderImpl.class, loader = AnnotationConfigContextLoader.class)
public class ShopProviderTest {

    @Autowired
    private IShopProvider shopProvider;

    @Test
    public void findByIdNoContentTest(){
        ShopResponseDTO dto = shopProvider.findById(1L);
        log.info(dto.exception);
    }

    @Test
    public void deletedByIdCantDelete(){
        shopProvider.deleteById(1L);
    }
    @Test
    public void createdShopCantCreate(){
        ShopResponseDTO dto = new ShopResponseDTO(1,"Tienda Junito","Madriz","Calle alcala");
        shopProvider.createShop(dto);
    }

}
