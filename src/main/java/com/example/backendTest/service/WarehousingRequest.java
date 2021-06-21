package com.example.backendTest.service;

import com.example.backendTest.domain.dto.ItemsDTO;
import com.example.backendTest.domain.entity.ClothesEntity;
import com.example.backendTest.domain.entity.FoodEntity;
import com.example.backendTest.domain.entity.OrderEntity;
import com.example.backendTest.domain.entity.WarehouseEntity;
import com.example.backendTest.repository.ClothesRepository;
import com.example.backendTest.repository.FoodRepository;
import com.example.backendTest.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousingRequest {
    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehousingRequest(FoodRepository foodRepository, ClothesRepository clothesRepository, WarehouseRepository warehouseRepository) {
        this.foodRepository = foodRepository;
        this.clothesRepository = clothesRepository;
        this.warehouseRepository = warehouseRepository;
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
            warehousingRequest(itemName, itemType);
        }
    }

    /**
     * 재고가 10개 미만이면 입고 요청테이블에 입력
     * 입고 요청은 암호화된 키값
     * 옷이면 이름 뒤에 숫자 123 / 음식이면 이름 앞에 숫자 123
     */
    public void warehousingRequest(String itemName, String itemType) {
        System.out.println("WarehousingRequest.warehousingRequest");
        final int count = 100; // 입고 요청 개수
        String encryptName = "";

        // 아이템 이름 암호화
        if (itemType.equals("food")){
            encryptName = "123" + itemName;
        } else if (itemType.equals("clothes")) {
            encryptName = itemName + "123";
        }

        WarehouseEntity warehouseEntity = new WarehouseEntity(
                itemName,
                encryptName,
                count
        );

        WarehouseEntity save = warehouseRepository.save(warehouseEntity);

        System.out.println(save.getName());
        System.out.println(save.getEncryptName());
        System.out.println(save.getCount());


        // 이미 입고 요청을 했을 경우는 어떻게 판단?

    }

}
