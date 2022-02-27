package com.t3h.news.controller.api;

import com.t3h.news.model.CategoryModel;
import com.t3h.news.model.entity.CategoryEntity;
import com.t3h.news.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/category")
public class CategoryApiController {

    private final ICategoryService iCategoryService;

    public CategoryApiController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryModel>> findAll(){
        return ResponseEntity.ok(iCategoryService.findAll());
    }

    @PostMapping()
    public ResponseEntity<CategoryModel> create(@RequestBody CategoryModel categoryModel){
        return ResponseEntity.ok(iCategoryService.add(categoryModel));
    }
}
