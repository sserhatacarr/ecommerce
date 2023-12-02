package dev.patika.ecommerce.api;

import dev.patika.ecommerce.bussiness.abstracts.ICategoryService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.request.category.CategoryUpdateRequest;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponse;
import dev.patika.ecommerce.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id) {
        Category category = this.categoryService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse(). map(category, CategoryResponse.class));
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursorPagination(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                                                         @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize
    ) {
        Page<Category> categoryPage = this.categoryService.cursorPagination(page, pageSize);
        Page <CategoryResponse> categoryResponsePage = categoryPage
                .map(category -> this.modelMapper.forResponse().map(category, CategoryResponse.class));

        return ResultHelper.cursor(categoryResponsePage);
    }
    @PutMapping ()
    @ResponseStatus(value = HttpStatus.OK)
    public ResultData<CategoryResponse> update( @Valid @RequestBody CategoryUpdateRequest categoryupdateRequest) {
        Category updatecategory = this.modelMapper.forRequest().map(categoryupdateRequest, Category.class);
        this.categoryService.update(updatecategory);
        return ResultHelper.success(this.modelMapper.forResponse().map(updatecategory, CategoryResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.categoryService.delete(id);
        return ResultHelper.Ok();
    }
}
