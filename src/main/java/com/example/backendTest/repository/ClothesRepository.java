package com.example.backendTest.repository;

import com.example.backendTest.domain.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ClothesEntity SET stock = stock - 1 WHERE id = :id")
    int changeStock(@Param("id")Long id);

}
