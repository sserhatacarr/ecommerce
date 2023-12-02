package dev.patika.ecommerce.bussiness.concrects;

import dev.patika.ecommerce.bussiness.abstracts.ISupplierService;
import dev.patika.ecommerce.core.utilies.Msg;
import dev.patika.ecommerce.dao.ISupplierRepo;
import dev.patika.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierManager implements ISupplierService {
    private final ISupplierRepo ISupplierRepo;

    public SupplierManager(ISupplierRepo ISupplierRepo) {
        this.ISupplierRepo = ISupplierRepo;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return ISupplierRepo.save(supplier);
    }

    @Override
    public Supplier get(int id) {
        return this.ISupplierRepo.findById(id).orElseThrow(() -> new RuntimeException(Msg.NOT_FOUND + " id: " + id));
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.ISupplierRepo.save(supplier);
    }

    @Override
    public boolean delete(int id) {
        Supplier supplier = this.get(id);
        this.ISupplierRepo.delete(supplier);
        return true;
    }

    @Override
    public Page<Supplier> cursorPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return this.ISupplierRepo.findAll(pageable);
    }
}
