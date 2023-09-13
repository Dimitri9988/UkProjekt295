package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.category.CategoryEntities;
import ch.csbe.backendlb.resources.category.CategoryService;
import ch.csbe.backendlb.resources.category.categorydto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.categorydto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.categorydto.CategoryMapper;
import ch.csbe.backendlb.resources.category.categorydto.CategoryUpdateDto;
import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productscategory")
public class productscategoryController {

    @Autowired CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/{id}")
    public CategoryDetailDto getById(@PathVariable Long id) {return categoryService.getById(id); }




    @GetMapping("{id}/products")
    public String getProductcategoryProductsByid(@PathVariable String id){
        return "hier währe meine producktkategory mit der id und passende Produkte= " + id;
    }





    @PutMapping("/{id}")
    public CategoryDetailDto update(@RequestBody CategoryUpdateDto category, @PathVariable Long id) {
        return  categoryService.update(id, category );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @PostMapping("")
    public CategoryDetailDto create(@RequestBody CategoryCreateDto category) {
        return categoryService.create(category);
    }




    @GetMapping("")
    public List<CategoryDetailDto> get() {
        return categoryService.get();
    }

}


