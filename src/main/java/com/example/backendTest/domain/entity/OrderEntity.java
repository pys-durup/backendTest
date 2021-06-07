package com.example.backendTest.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 주문
 * id
 * contactEmail
 * contactName
 * mobile
 * itemType
 * itemId
 */

@Entity
@Table(name = "tblOrder")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String contactEmail;

    @Column(length = 10, nullable = false)
    private String contactName;

    @Column(length = 15, nullable = false)
    private String mobile;

    @Column(length = 20, nullable = false)
    private String itemType;

    @Column(nullable = false)
    private Long itemId;

    @Builder
    public OrderEntity(Long id, String contactEmail, String contactName, String mobile, String itemType, Long itemId) {
        this.id = id;
        this.contactEmail = contactEmail;
        this.contactName = contactName;
        this.mobile = mobile;
        this.itemType = itemType;
        this.itemId = itemId;
    }
}
