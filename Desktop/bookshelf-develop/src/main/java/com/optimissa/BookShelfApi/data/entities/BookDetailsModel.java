package com.optimissa.BookShelfApi.data.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "BOOK_DETAILS")
public class BookDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 800000, nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate publication;

    @Column(nullable = false)
    private String family;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String editorial;

    @Builder
    public BookDetailsModel(String description,
                            LocalDate publication,
                            String family,
                            String language,
                            double price,
                            String editorial
    ) {
        this.description = description;
        this.publication = publication;
        this.family = family;
        this.language = language;
        this.price = price;
        this.editorial = editorial;
    }

}
