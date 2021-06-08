package com.example.backendTest.repository;

import com.example.backendTest.domain.entity.ProductEntity;

public interface ProductRepo {

    ProductEntity findByItemId(Long itemId);

}
