package com.example.backendTest.service;

import com.example.backendTest.repository.OrderVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private final OrderVerification orderVerification;

    @Autowired
    public OrderServiceImpl(OrderVerification orderVerification) {
        this.orderVerification = orderVerification;
    }

    // 주문 검증



    // 주문 저장





    // 입고 요청


}
