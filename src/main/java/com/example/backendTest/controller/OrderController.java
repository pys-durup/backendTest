package com.example.backendTest.controller;

import com.example.backendTest.domain.dto.ContactInfoDTO;
import com.example.backendTest.domain.dto.ItemsDTO;
import com.example.backendTest.service.OrderVerification;
import com.example.backendTest.service.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final OrderServiceImpl orderService;
    private final OrderVerification orderVerification;

    @Autowired
    public OrderController(OrderServiceImpl orderService, OrderVerification orderVerification) {
        this.orderService = orderService;
        this.orderVerification = orderVerification;
    }

    @PostMapping(value = "/order")
    public Object order(@RequestBody HashMap<String, Object> messageBody) {

        System.out.println("messageBody = " + messageBody);

        // 상품 주문자 정보
        ContactInfoDTO contactInfoDTO = objectMapper.convertValue(messageBody.get("contactInfo"), ContactInfoDTO.class);

        // 주문 상품 정보
        ItemsDTO itemsDTO = objectMapper.convertValue(messageBody.get("items"), ItemsDTO.class);

        // 상품 검증 - 상품이 있는지
        boolean hasProduct = orderVerification.hasProduct(itemsDTO.getItemType(), itemsDTO.getId());

        if (hasProduct == false) {
            // 상품 없음 에러 반환
            System.out.println("There is no item");
            return new ResponseEntity("There is no item", HttpStatus.BAD_REQUEST);

        }

        // 상품 검증 - 재고가 0개 이상으로 주문 가능한지
        boolean canOrder = orderVerification.canOrder(itemsDTO.getItemType(), itemsDTO.getId());

        if (canOrder == false) {
            // 상품 재고 0 에러 반환
            System.out.println("There is no stock");
            return new ResponseEntity("There is no stock", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        // 주문 정보 저장



        return "restTest";
    }

}
