package com.optimissa.BookShelfApi.data.providers.impl;

import com.optimissa.BookShelfApi.data.daos.*;
import com.optimissa.BookShelfApi.data.entities.*;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.IBookProvider;
import com.optimissa.BookShelfApi.dto.error.ErrorFactoryDTO;
import com.optimissa.BookShelfApi.dto.request.BookRequestDTO;
import com.optimissa.BookShelfApi.dto.response.BookResponseDTO;
import com.optimissa.BookShelfApi.dto.response.OldBookResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookProviderImpl implements IBookProvider {

    private static final ErrorFactoryDTO<BookResponseDTO> bookResponseErrorFactory =
            ErrorFactoryDTO.of(BookResponseDTO.class);

    private static final ErrorFactoryDTO<OldBookResponseDTO> oldResponseErrorFactory =
            ErrorFactoryDTO.of(OldBookResponseDTO.class);

    private final IAuthorDao authorDao;
    private final IBookDao bookDao;
    private final IBookDetailsDao bookDetailsDao;
    private final IShopDao shopDao;
    private final ISampleDao sampleDao;
    private final IBrokenDetailsDao brokenDetailsDao;

    private final IMapper<BookModel, BookRequestDTO> bookRequestMapper;
    private final IMapper<BookModel, BookResponseDTO> bookResponseMapper;
    private final IMapper<SampleModel, OldBookResponseDTO> bookOldResponseMapper;

    @Override
    public BookResponseDTO registerBook(BookRequestDTO dto) {
        if (bookDao.existsById(dto.isbn))
           return bookResponseErrorFactory.error("That book with that isbn already exists!");

        AuthorModel author = authorDao.findByName(dto.author).orElse(null);
        if (author == null)
            return bookResponseErrorFactory.error("That author does not exists!");

        BookModel book = bookRequestMapper.mapToEntity(dto);

        book.setAuthor(author);
        book.setBookDetails(bookDetailsDao.save(book.getBookDetails()));

        book = bookDao.save(book);

        return bookResponseMapper.mapToDto(book);
    }

    @Override
    public BookResponseDTO addBook(String isbn, long shopID) {
        ShopModel shop = shopDao.findById(shopID).orElse(null);
        if (shop == null)
            return bookResponseErrorFactory.error("No shop found with that id");

        BookModel book = bookDao.findById(isbn).orElse(null);
        if (book == null)
            return bookResponseErrorFactory.error("no book found with that isbn");

        SampleModel sample = SampleModel.builder()
                .shop(shop)
                .book(book)
                .isNew(true)
                .build();

        sampleDao.save(sample);

        return bookResponseMapper.mapToDto(book);
    }

    @Override
    public OldBookResponseDTO addSecondHandBook(String isbn, long shopID, String status, double price) {
        ShopModel shop = shopDao.findById(shopID).orElse(null);
        if (shop == null)
            return oldResponseErrorFactory.error("No shop found with that id");

        BookModel book = bookDao.findById(isbn).orElse(null);
        if (book == null)
            return oldResponseErrorFactory.error("no book found with that isbn");

        SampleModel sample = SampleModel.builder()
                .shop(shop)
                .book(book)
                .isNew(false)
                .build();

        sample = sampleDao.save(sample);

        BrokenDetailsModel brokenDetails = BrokenDetailsModel.builder()
                .sample(sample)
                .status(status)
                .priceMultiplier(price / sample.getBook().getBookDetails().getPrice())
                .build();

        brokenDetailsDao.save(brokenDetails);

        return bookOldResponseMapper.mapToDto(sample);
    }

    @Override
    public BookResponseDTO getBook(String isbn) {
        return bookDao.findById(isbn)
                .map(bookResponseMapper::mapToDto)
                .orElse(bookResponseErrorFactory.error("no book found with that id"));
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookResponseMapper.mapListToDtoList(bookDao.findAll());
    }

    @Override
    public List<OldBookResponseDTO> getAllSecondHandBooks() {
        return bookDao.findAll().stream()
                .flatMap(bookModel -> bookModel.getSamples().stream())
                .filter(sampleModel -> !sampleModel.isNew())
                .map(bookOldResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO unregisterBook(String isbn) {
        return bookDao.findById(isbn)
                .map(bookModel -> {
                    bookDao.delete(bookModel);
                    return bookResponseMapper.mapToDto(bookModel);
                }).orElse(bookResponseErrorFactory.error("no book found with that isbn"));
    }

    @Override
    public BookResponseDTO deleteBook(String isbn) {
        BookModel book = bookDao.findById(isbn).orElse(null);
        if (book == null)
            return bookResponseErrorFactory.error("no book found with that isbn");

        try {
            SampleModel sample = book.getSamples().get(0);
            sampleDao.delete(sample);
            return bookResponseMapper.mapToDto(book);

        } catch (IndexOutOfBoundsException ignored) {
            return bookResponseErrorFactory.error("there are no more books left");
        }
    }

    @Override
    public OldBookResponseDTO deleteBook(long secondHandBookID) {
        return sampleDao.findById(secondHandBookID)
                .map(sampleModel -> {
                    if (sampleModel.isNew())
                        return oldResponseErrorFactory.error("That book you are trying to delete is not second hand");

                    sampleDao.delete(sampleModel);
                    return bookOldResponseMapper.mapToDto(sampleModel);
                }).orElse(oldResponseErrorFactory.error("no book found with that id"));
    }
}
