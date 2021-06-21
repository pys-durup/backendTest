package com.example.backendTest.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 입고 요청
 * id
 * name
 * encryptName
 * count
 */
@Entity
@Table(name = "tblWarehouseRequest")
@Getter
@NoArgsConstructor
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 40, nullable = false)
    private String encryptName;

    @Column(nullable = false)
    private Integer count;

    @Builder
    public WarehouseEntity(String name, String encryptName, Integer count) {
        this.name = name;
        this.encryptName = encryptName;
        this.count = count;
    }
}
