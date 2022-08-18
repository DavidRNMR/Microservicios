package com.optimissa.BookShelfApi.data.daos;

import com.optimissa.BookShelfApi.data.entities.BrokenDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrokenDetailsDao extends JpaRepository<BrokenDetailsModel,Long> {

}
