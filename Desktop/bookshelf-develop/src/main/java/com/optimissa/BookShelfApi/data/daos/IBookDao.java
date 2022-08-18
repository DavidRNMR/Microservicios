package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBookDao extends JpaRepository<BookModel,String> {

    Optional<BookModel> findById(String isbn);

    Optional<BookModel> findByTitle(String title);

    List<BookModel> findAllByAuthor_Name(String name);
    List<BookModel> findAll();

}
