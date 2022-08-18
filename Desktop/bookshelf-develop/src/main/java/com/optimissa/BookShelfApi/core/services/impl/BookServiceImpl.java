package com.optimissa.BookShelfApi.core.services.impl;

import com.optimissa.BookShelfApi.core.services.IBookService;
import com.optimissa.BookShelfApi.data.providers.IBookProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.BookResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBookService  {


    private final IBookProvider bookProvider;


    @Override
    public BookResponseDTO findBookByISBN(String isbn) {
        return bookProvider.getBookByIsbn(isbn);
    }

    @Override
    public BookResponseDTO findBookByTitle(String title) {
        return bookProvider.getBookByTitle(title);
    }

    @Override
    public List<BookResponseDTO> findAllByAuthorName(String authorName) {
        return (List<BookResponseDTO>) bookProvider.getAllByAuthorName();
    }

    @Override
    public List<BookResponseDTO> getAll() {
        return (List<BookResponseDTO>) bookProvider.getAll();
    }

    @Override
    public BookResponseDTO createBook(BookResponseDTO bookResponseDTO) {
        return null;
    }

    @Override
    public BookResponseDTO deleteBookByISBN(String isbn) {
        return null;
    }
}
