package dev.patika.ecommerce.dao;

import dev.patika.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo  extends JpaRepository<Product, Integer> {
}
