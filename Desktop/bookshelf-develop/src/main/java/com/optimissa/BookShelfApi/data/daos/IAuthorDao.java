package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthorDao extends JpaRepository<AuthorModel,Long> {

    Optional<AuthorModel> findByName(String username);

}
