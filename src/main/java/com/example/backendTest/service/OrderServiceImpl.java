package com.example.backendTest.service;

import com.example.backendTest.domain.dto.ContactInfoDTO;
import com.example.backendTest.domain.dto.ItemsDTO;
import com.example.backendTest.domain.entity.ClothesEntity;
import com.example.backendTest.domain.entity.FoodEntity;
import com.example.backendTest.domain.entity.OrderEntity;
import com.example.backendTest.repository.ClothesRepository;
import com.example.backendTest.repository.FoodRepository;
import com.example.backendTest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final ClothesRepository clothesRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository, ClothesRepository clothesRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.clothesRepository = clothesRepository;
    }



    // 주문 저장
    @Transactional
    public OrderEntity saveOrderInfo(ContactInfoDTO contactInfoDTO, ItemsDTO itemsDTO) {
        OrderEntity orderEntity = new OrderEntity(
                contactInfoDTO.getContactEmail(),
                contactInfoDTO.getContactName(),
                contactInfoDTO.getMobile(),
                itemsDTO.getItemType(),
                itemsDTO.getId()
        );

        // 재고 감소
        changeStock(itemsDTO);

        return orderRepository.save(orderEntity);
    }

    // 재고 감소
    public void changeStock(ItemsDTO itemsDTO) {
        String itemType = itemsDTO.getItemType();
        Long itemId = itemsDTO.getId();

        if (itemType.equals("food")) {
            int changeStock = foodRepository.changeStock(itemId);
            System.out.println("changeStockOK = " + changeStock);


        } else if (itemType.equals("clothes")) {
            int changeStock = clothesRepository.changeStock(itemId);
            System.out.println("changeStockOK = " + changeStock);
        }

    }
}

