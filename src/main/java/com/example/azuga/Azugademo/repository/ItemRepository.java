package com.example.azuga.Azugademo.repository;

import com.example.azuga.Azugademo.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
