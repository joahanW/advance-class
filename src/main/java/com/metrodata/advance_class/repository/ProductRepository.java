package com.metrodata.advance_class.repository;

import com.metrodata.advance_class.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
