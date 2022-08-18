package com.optimissa.BookShelfApi.data.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "sample")
@Table(name = "BROKEN_DETAILS")
public class BrokenDetailsModel {

    @Id
    private long id;
    private String status;
    private double priceMultiplier;

    @OneToOne
    @MapsId
    private SampleModel sample;

    @Builder
    public BrokenDetailsModel(SampleModel sample, String status, double priceMultiplier) {
        this.sample = sample;
        this.status = status;
        this.priceMultiplier = priceMultiplier;
    }

}
