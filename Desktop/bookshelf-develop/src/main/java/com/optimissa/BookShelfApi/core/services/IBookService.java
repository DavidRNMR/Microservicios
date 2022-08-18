package com.optimissa.BookShelfApi.core.services;

import com.optimissa.BookShelfApi.data.providers.impl.dto.response.BookResponseDTO;

import java.util.List;

/**
 * This class represents all the relevant methods to get information about Book from the database.
 */
public interface IBookService {

   BookResponseDTO findBookByISBN(String isbn);
   BookResponseDTO findBookByTitle(String title);
   List<BookResponseDTO> findAllByAuthorName(String authorName);
   List<BookResponseDTO> getAll();
   BookResponseDTO createBook(BookResponseDTO bookResponseDTO);
   BookResponseDTO deleteBookByISBN(String isbn);





}

