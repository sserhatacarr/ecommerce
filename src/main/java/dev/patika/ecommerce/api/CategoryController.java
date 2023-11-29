package dev.patika.ecommerce.api;

import dev.patika.ecommerce.bussiness.abstracts.ICategoryService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.dto.request.CategorySaveRequest;
import dev.patika.ecommerce.dto.response.CategoryResponse;
import dev.patika.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public CategoryResponse save (@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest,Category.class);
        this.categoryService.save(saveCategory);
        return this.modelMapper.forResponse().map(saveCategory,CategoryResponse.class);
    }
}
