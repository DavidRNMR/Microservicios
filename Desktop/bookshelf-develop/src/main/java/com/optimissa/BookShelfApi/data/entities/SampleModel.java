package com.optimissa.BookShelfApi.data.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "SAMPLES")
public class SampleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private BookModel book;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID", nullable = false)
    private ShopModel shop;

    private boolean isNew = true;

    @OneToOne(mappedBy = "sample")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BrokenDetailsModel brokenDetails;

    @Builder
    public SampleModel(BookModel book, ShopModel shop, boolean isNew) {
        this.book = book;
        this.shop = shop;
        this.isNew = isNew;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", book=" + book.getId() +
                ", shop=" + shop.getId() +
                '}';
    }

}
