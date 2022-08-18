package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.BookDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDetailsDao extends JpaRepository<BookDetailsModel, Long> {
}
