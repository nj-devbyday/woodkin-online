package me.nolanjames.woodkin.repository;

import me.nolanjames.woodkin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
