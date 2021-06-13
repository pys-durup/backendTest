//package com.example.backendTest.repository;
//
//import com.example.backendTest.domain.entity.OrderEntity;
//import com.example.backendTest.domain.entity.ProductEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderVerification {
//
//    private final FoodRepository foodRepository;
//    private final ClothesRepository clothesRepository;
//
//    @Autowired
//    public OrderVerification(FoodRepository foodRepository, ClothesRepository clothesRepository) {
//        this.foodRepository = foodRepository;
//        this.clothesRepository = clothesRepository;
//    }
//
//
//    /**
//     * 해당 상품이 존재하는지?
//     * 상품 타입, 상품 ID
//     * @return 상품의 존재 여부
//     */
//    public boolean hasProduct(String itemType, Long itemId) {
//
//        if (itemType.equals("food")) {
//
//        }
//
//        ProductEntity productEntity = foodRepository.findByItemId(itemId);
//        if (productEntity != null) {
//            return true;
//        }
//
//        return false;
//    }
//
//
//    /**
//     * 해당 상품의 재고가 남아있는지 (0개 이상)
//     * @return
//     */
//    public boolean canOrder() {
//
//        return false;
//    }
//
//}
