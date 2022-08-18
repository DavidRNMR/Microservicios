package com.optimissa.BookShelfApi.data.providers;

import com.optimissa.BookShelfApi.dto.response.RentedBookResponseDTO;

import java.util.List;

public interface IRentBookProvider {

    /**
     * Rents a second hand book for a specific user
     * @param OldSampleID the old book id to be rented
     * @param user the username of the user that wants to rent the book
     * @return the dto holding the data of the transaction
     */
    RentedBookResponseDTO rentBook(long OldSampleID, String user);

    /**
     * Returns a second hand rented book from a user
     * @param oldSampleID the book id to return
     * @param user the user that returns this book
     * @return the dto holding the data of this transaction
     */
    RentedBookResponseDTO returnBook(long oldSampleID, String user);

    /**
     * Returns the list of all the rented books for a specific users
     * @param user the username of the user to check all the rented books
     * @return a list of all the rented books of that user
     */
    List<RentedBookResponseDTO> getUserRentedBooks(String user);

}
