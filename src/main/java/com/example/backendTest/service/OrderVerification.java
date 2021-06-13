package com.example.backendTest.service;

import com.example.backendTest.domain.entity.ClothesEntity;
import com.example.backendTest.domain.entity.FoodEntity;
import com.example.backendTest.repository.ClothesRepository;
import com.example.backendTest.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderVerification {

    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;
    private String itemType;

    @Autowired
    public OrderVerification(FoodRepository foodRepository, ClothesRepository clothesRepository) {
        this.foodRepository = foodRepository;
        this.clothesRepository = clothesRepository;
    }

    /**
     * 해당 상품이 존재하는지?
     * 상품 타입, 상품 ID
     * @return 상품의 존재 여부
     */
    public boolean hasProduct(String itemType, Long itemId) {
        boolean hasProduct = true;
        System.out.println("OrderVerification.hasProduct");

        if (itemType.equals("food")) {
            Optional<FoodEntity> foodEntity = foodRepository.findById(itemId);
            hasProduct = foodEntity.isPresent();

        } else if (itemType.equals("clothes")) {
            Optional<ClothesEntity> clothesEntity = clothesRepository.findById(itemId);
            hasProduct = clothesEntity.isPresent();
        }

        System.out.println("OrderVerification.hasProduct = " + hasProduct);
        return hasProduct;
    }


    /**
     * 해당 상품의 재고가 남아있는지 (0개 이상)
     * @return
     */
    public boolean canOrder(String itemType, Long itemId) {

        System.out.println("OrderVerification.canOrder");

        if (itemType.equals("food")) {
            Optional<FoodEntity> entity = foodRepository.findById(itemId);
            FoodEntity foodEntity = entity.get();
            return foodEntity.getStock() > 0 ? true : false;

        } else if (itemType.equals("clothes")) {
            Optional<ClothesEntity> entity = clothesRepository.findById(itemId);
            ClothesEntity clothesEntity = entity.get();
            return clothesEntity.getStock() > 0 ? true : false;
        }

        return false;
    }

}
