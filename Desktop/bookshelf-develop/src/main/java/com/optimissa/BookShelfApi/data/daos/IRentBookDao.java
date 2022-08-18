package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.RentBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentBookDao extends JpaRepository<RentBookModel, Long> {

    List<RentBookModel> findAllByUserUsername(String username);

}
