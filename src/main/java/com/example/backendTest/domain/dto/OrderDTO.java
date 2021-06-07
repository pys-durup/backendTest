package com.example.backendTest.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class OrderDTO {
    private String contactEmail;
    private String contactName;
    private String mobile;
    private String itemType;
    private Long itemId;
}
