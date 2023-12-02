package dev.patika.ecommerce.bussiness.concrects;

import dev.patika.ecommerce.bussiness.abstracts.ICategoryService;
import dev.patika.ecommerce.core.exception.NotFoundException;
import dev.patika.ecommerce.core.utilies.Msg;
import dev.patika.ecommerce.dao.ICategoryRepo;
import dev.patika.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return this.categoryRepo.findById(id).orElseThrow(() ->
        new NotFoundException(Msg.NOT_FOUND + " id: " + id));
    }

    @Override
    public Page<Category> cursorPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }

}
