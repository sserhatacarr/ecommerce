package dev.patika.ecommerce.bussiness.abstracts;

import dev.patika.ecommerce.entities.Product;
import org.springframework.data.domain.Page;

public interface IProductService {
    Product save(Product product);
    Product get(int id);
    Page<Product> cursorPagination(int page, int size);
    Product update(Product product);
    boolean delete(int id);
}
