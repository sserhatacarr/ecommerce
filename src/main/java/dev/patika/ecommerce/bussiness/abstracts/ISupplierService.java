package dev.patika.ecommerce.bussiness.abstracts;

import dev.patika.ecommerce.entities.Supplier;
import org.springframework.data.domain.Page;


public interface ISupplierService {
    Supplier save(Supplier supplier);
    Supplier get(int id);
    Supplier update(Supplier supplier);
    boolean delete(int id);
    Page<Supplier> cursorPagination(int page, int size);
}
