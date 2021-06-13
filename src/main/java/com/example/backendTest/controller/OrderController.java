package com.example.backendTest.controller;

import com.example.backendTest.domain.dto.ContactInfoDTO;
import com.example.backendTest.domain.dto.ItemsDTO;
import com.example.backendTest.domain.dto.OrderDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class OrderController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/order")
    public String order(@RequestBody HashMap<String, Object> messageBody) throws IOException {

        System.out.println("messageBody = " + messageBody);
        System.out.println("messageBody.get(\"contactInfo\") = " + messageBody.get("contactInfo"));

        ContactInfoDTO contactInfoDTO = objectMapper.convertValue(messageBody.get("contactInfo"), ContactInfoDTO.class);
        ItemsDTO itemsDTO = objectMapper.convertValue(messageBody.get("items"), ItemsDTO.class);

        System.out.println(contactInfoDTO.getContactName());
        System.out.println(contactInfoDTO.getContactEmail());
        System.out.println(contactInfoDTO.getMobile());
        System.out.println(itemsDTO.getItemType());
        System.out.println(itemsDTO.getId());

        return "restTest";
    }

}
