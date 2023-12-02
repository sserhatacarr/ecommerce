package dev.patika.ecommerce.bussiness.abstracts;

import dev.patika.ecommerce.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);
    Page<Category> cursorPagination(int page, int size);

}
