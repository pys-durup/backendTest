package com.example.backendTest.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *     "contactInfo": {
 *             "contactEmail": "test@test.com",
 *             "contactName": "   구매자   ",
 *             "mobile": "01099999999    "
 *             },
 */
@Setter @Getter @NoArgsConstructor
public class ContactInfoDTO {
    private String contactEmail;
    private String contactName;
    private String mobile;
}


