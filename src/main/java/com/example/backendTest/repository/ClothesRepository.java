package com.example.backendTest.repository;

import com.example.backendTest.domain.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {
}
