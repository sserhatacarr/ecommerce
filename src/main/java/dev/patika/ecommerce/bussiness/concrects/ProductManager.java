package dev.patika.ecommerce.bussiness.concrects;

import dev.patika.ecommerce.bussiness.abstracts.IProductService;
import dev.patika.ecommerce.core.exception.NotFoundException;
import dev.patika.ecommerce.core.utilies.Msg;
import dev.patika.ecommerce.dao.IProductRepo;
import dev.patika.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements IProductService {
    private final IProductRepo productRepo;

    public ProductManager(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public Product save(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public Product get(int id) {
    return this.productRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND  +"id: " + id));
    }

    @Override
    public Page<Product> cursorPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.productRepo.findAll(pageable);
    }

    @Override
    public Product update(Product product) {
        this.get(product.getId());
        return this.productRepo.save(product);
    }

    @Override
    public boolean delete(int id) {
        Product product = this.get(id);
        this.productRepo.delete(product);
        return true;
    }
}
