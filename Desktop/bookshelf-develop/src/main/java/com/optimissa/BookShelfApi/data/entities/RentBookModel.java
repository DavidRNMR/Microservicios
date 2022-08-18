package com.optimissa.BookShelfApi.data.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "RENT_BOOKS")
public class RentBookModel {

    @Id
    @Column(name = "SAMPLE_ID", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserModel user;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "SAMPLE_ID", nullable = false)
    private SampleModel sample;

    @Builder
    public RentBookModel(UserModel user, LocalDate startDate, LocalDate endDate, SampleModel sample) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sample = sample;
    }

}
