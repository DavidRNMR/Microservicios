package com.optimissa.BookShelfApi.data.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "BOOKS")
public class BookModel {

    @Id
    @Column(name = "ISBN", nullable = false)
    private String id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private AuthorModel author;

    @OneToOne
    @JoinColumn(name = "BOOK_DETAILS_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BookDetailsModel bookDetails;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SampleModel> samples;  // Returns null ?¿?¿?¿

    @Builder
    public BookModel(String id, String title, AuthorModel author, BookDetailsModel bookDetails) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookDetails = bookDetails;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author.getId() +
                ", bookDetails=" + bookDetails +
                '}';
    }

}
