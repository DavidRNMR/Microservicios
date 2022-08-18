package com.optimissa.BookShelfApi.data.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Table(name = "BANNED_USERS")
public class BannedUsersModel {

    @Id
    private String mail;
    private LocalDateTime bannedAt;
    private LocalDateTime expiredAt;

    @MapsId
    @OneToOne
    private UserModel user;

    @Builder
    public BannedUsersModel(LocalDateTime bannedAt, LocalDateTime expiredAt, UserModel user) {
        this.bannedAt = bannedAt;
        this.expiredAt = expiredAt;
        this.user = user;
    }

}
