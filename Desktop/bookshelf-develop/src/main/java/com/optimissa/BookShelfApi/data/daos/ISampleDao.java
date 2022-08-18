package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.SampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISampleDao extends JpaRepository<SampleModel,Long> {

    Optional<SampleModel> getById(long id);

    Optional<SampleModel> findByBook_Id(long id);

    Optional<SampleModel> findByShopId(long id);

    /*
    * Este metodo me devuelve un contador de los libros nuevos
    * */
    int countAllByBook_IdAndIsNewIsTrue(String isbn);

    /*
    * Este metodo me devuelve un contador de los libros que no son nuevos*/
    int countAllByBook_IdAndIsNewIsFalse(String isbn);
}
