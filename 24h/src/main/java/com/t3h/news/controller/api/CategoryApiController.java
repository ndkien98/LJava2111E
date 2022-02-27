package com.t3h.news.controller.api;

import com.t3h.news.model.CategoryModel;
import com.t3h.news.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  RestService -> json
 *  soap -> xml
 *
 */
@RestController
@RequestMapping("api/admin/category")
public class CategoryApiController {


    private final ICategoryService iCategoryService;


    public CategoryApiController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryModel>> getAll(){
        return ResponseEntity.ok(iCategoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> findById(@PathVariable int id){
        return ResponseEntity.ok(iCategoryService.findById(id));
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CategoryModel categoryModel){
        iCategoryService.add(categoryModel);
        return ResponseEntity.ok().build();
    }
}
