package com.example.backendTest.controller;

import com.example.backendTest.domain.dto.ContactInfo;
import com.example.backendTest.domain.dto.Items;
import com.example.backendTest.domain.dto.OrderDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    @PostMapping(value = "/order")
    public String order(@RequestBody HashMap<String, Object> map) {

        System.out.println(map);
        map.get("contactInfo");

        return "restTest";
    }

//    @PostMapping(value = "/order")
//    public String order(@RequestBody OrderDTO orderDTO) {
//
//        System.out.println(orderDTO.getContactEmail());
//
//        return "restTest";
//    }
}
