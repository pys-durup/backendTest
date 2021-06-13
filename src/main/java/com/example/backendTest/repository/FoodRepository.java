package com.example.backendTest.repository;

import com.example.backendTest.domain.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
