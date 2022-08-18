package com.optimissa.BookShelfApi.data.providers;

import com.optimissa.BookShelfApi.data.providers.impl.dto.request.BookRequestDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.BookResponseDTO;
import com.optimissa.BookShelfApi.data.providers.impl.dto.response.OldBookResponseDTO;

import java.util.List;

/**
 * Show DATA methods to the front-end.
 */
public interface IBookProvider {

    /**
     * Adds a new book to be tracked
     */
    BookResponseDTO registerBook(BookRequestDTO dto);

    /**
     * Adds a book, in short, increments in one the stock
     */
    BookResponseDTO addBook(String isbn, long shopID);

    List<BookResponseDTO> getAll();
    BookResponseDTO getAllByAuthorName();
    /**
     * Adds a second hand book
     */
    OldBookResponseDTO addSecondHandBook(String isbn, long shopID, String status, double price);

    /**
     * Gets a new book and its stock
     *
     * @return return a book with the stock
     */
    BookResponseDTO getBook(String isbn);

    /**
     * Gets all books and its stocks
     *
     * @return gets all the books with stocks
     */
    List<BookResponseDTO> getAllBooks();

    /**
     * Returns all second hand books
     *
     * @return returns all the second hand books
     */
    List<OldBookResponseDTO> getAllSecondHandBooks();

    /**
     * Untracks a book from the database and deletes all instances
     *
     * @return the book unregistered and the stock it had previously
     */
    BookResponseDTO unregisterBook(String isbn);

    /**
     * Deletes a book, in short, subtracts 1 from stock
     *
     * @return the book with the new stock.
     **/
    BookResponseDTO deleteBook(String isbn);

    /**
     * Removes a second hand book
     *
     * @return the second hand book deleted
     */
    OldBookResponseDTO deleteBook(long secondHandBookID);

}
