package com.example.backendTest.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tblFood")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer stock;

    @Column(length = 30, nullable = false)
    private String itemName;

    @Builder
    public FoodEntity(Long id, Integer stock, String itemName) {
        this.id = id;
        this.stock = stock;
        this.itemName = itemName;
    }
}