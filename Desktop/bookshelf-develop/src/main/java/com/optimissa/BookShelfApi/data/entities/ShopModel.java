package com.optimissa.BookShelfApi.data.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "books")
@Table(name = "SHOPS")
public class ShopModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String direction;

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<SampleModel> books;

    @Builder
    public ShopModel(long id, String name, String city, String direction) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.direction = direction;
    }

}
