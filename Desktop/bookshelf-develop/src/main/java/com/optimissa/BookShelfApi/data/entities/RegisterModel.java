package com.optimissa.BookShelfApi.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "user")
@Table(name = "REGISTER")
public class RegisterModel {

    @EmbeddedId
    private RegisterPK id = new RegisterPK();

    @Enumerated(EnumType.STRING)
    private Type type;

    @MapsId("bookId")
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookModel book;

    @MapsId("mail")
    @ManyToOne
    @JoinColumn(name = "user_mail", nullable = false)
    private UserModel user;

    @Builder
    public RegisterModel(Type type, BookModel book, UserModel user) {

        this.type = type;
        this.book = book;
        this.user = user;
    }

    public enum Type {
        BUY,
        SELL,
        RENT,
        END_RENT
    }

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RegisterPK implements Serializable {

        @Column(name = "user_mail", nullable = false)
        private String mail;

        @Column(name = "book_isbn", nullable = false)
        private String bookId;

        @Column(name = "date", nullable = false)
        private LocalDateTime date = LocalDateTime.now();

    }
}



