package com.example.backendTest.service;

import com.example.backendTest.domain.dto.ItemsDTO;
import com.example.backendTest.domain.entity.ClothesEntity;
import com.example.backendTest.domain.entity.FoodEntity;
import com.example.backendTest.repository.ClothesRepository;
import com.example.backendTest.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousingRequest {
    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;

    @Autowired
    public WarehousingRequest(FoodRepository foodRepository, ClothesRepository clothesRepository) {
        this.foodRepository = foodRepository;
        this.clothesRepository = clothesRepository;
    }

    // 재고를 체크하는 메서드
    public void checkStock(ItemsDTO itemsDTO) {
        String itemType = itemsDTO.getItemType();
        Long id = itemsDTO.getId();
        Integer stock = 0;
        String itemName = "";

        if (itemType.equals("food")) {
            FoodEntity foodEntity = foodRepository.getOne(id);
            stock = foodEntity.getStock();
            itemName = foodEntity.getItemName();

        } else if (itemType.equals("clothes")) {
            ClothesEntity clothesEntity = clothesRepository.getOne(id);
            stock = clothesEntity.getStock();
            itemName = clothesEntity.getItemName();
        }

        // 재고가 10개 미만
        if (stock < 10) {
            // 입고 요청
            warehousingRequest(itemName);
        }
    }

    /**
     * 재고가 10개 미만이면 입고 요청테이블에 입력
     * 입고 요청은 암호화된 키값
     * 옷이면 이름 뒤에 숫자 123
     * 음식이면 이름 앞에 숫자 123
     * @param itemName
     */
    public void warehousingRequest(String itemName) {
        System.out.println("WarehousingRequest.warehousingRequest");



    }

}
