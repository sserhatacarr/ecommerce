package dev.patika.ecommerce.bussiness.concrects;

import dev.patika.ecommerce.bussiness.abstracts.ICategoryService;
import dev.patika.ecommerce.dao.ICategoryRepo;
import dev.patika.ecommerce.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    private final ICategoryRepo categoryRepo;

    public CategoryManager(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
       return this.categoryRepo.findById(id).orElseThrow();
    }

}
