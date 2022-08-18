package com.optimissa.BookShelfApi.data.providers.impl;

import com.optimissa.BookShelfApi.data.daos.IRentBookDao;
import com.optimissa.BookShelfApi.data.daos.ISampleDao;
import com.optimissa.BookShelfApi.data.daos.IUserDao;
import com.optimissa.BookShelfApi.data.entities.RentBookModel;
import com.optimissa.BookShelfApi.data.entities.SampleModel;
import com.optimissa.BookShelfApi.data.entities.UserModel;
import com.optimissa.BookShelfApi.data.mappers.IMapper;
import com.optimissa.BookShelfApi.data.providers.IRentBookProvider;
import com.optimissa.BookShelfApi.dto.response.RentedBookResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RentBookProviderImpl implements IRentBookProvider {

    private final IRentBookDao rentBookDao;
    private final ISampleDao sampleDao;
    private final IUserDao userDao;

    private final IMapper<RentBookModel, RentedBookResponseDTO> mapper;

    @Override
    public RentedBookResponseDTO rentBook(long oldSampleID, String username) {
        UserModel user = userDao.getByUsername(username).orElse(null);
        if(user == null)
            return null; // TODO

        SampleModel book = sampleDao.findById(oldSampleID).orElse(null);
        if (book == null)
            return null; //TODO

        if (book.isNew())
            return null; //TODO

        if (rentBookDao.existsById(oldSampleID))
            return null; // TODO that book is already rented

        RentBookModel rentBook = RentBookModel.builder()
                .sample(book)
                .user(user)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        rentBook = rentBookDao.save(rentBook);

        return mapper.mapToDto(rentBook);
    }

    @Override
    public RentedBookResponseDTO returnBook(long oldSampleID, String username) {
        UserModel user = userDao.getByUsername(username).orElse(null);
        if(user == null)
            return null; // TODO

        SampleModel book = sampleDao.findById(oldSampleID).orElse(null);
        if (book == null)
            return null; //TODO

        RentBookModel rentBook = rentBookDao.findById(oldSampleID).orElse(null);
        if (rentBook == null)
            return null; // TODO there is no rented book by that id

        if (!rentBook.getUser().getUsername().equals(username))
            return null; // TODO there is no

        return null;
    }

    @Override
    public List<RentedBookResponseDTO> getUserRentedBooks(String user) {
        return null;
    }
}
