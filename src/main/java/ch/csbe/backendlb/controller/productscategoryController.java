package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resources.category.CategoryEntities;
import ch.csbe.backendlb.resources.category.CategoryService;
import ch.csbe.backendlb.resources.category.categorydto.*;
import ch.csbe.backendlb.resources.product.ProductEntitie;
import ch.csbe.backendlb.resources.product.ProductService;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CategoryController", description = "Controller für Kategorien")
@RequestMapping("/productscategories")
public class productscategoryController {

    @Autowired CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping("/{id}")
    public CategoryDetailDto getById(@PathVariable Long id) {return categoryService.getById(id); }


    @GetMapping("{name}/products")
    @Operation(summary = "gibt alle Produkte einer gewissen Kategory aus", operationId = "getCategoryProducts", description = "es werden alle Produkte ausgegeben welche in der angegebenen Kategory sind")

    public List<ProductDetailDto> get(@PathVariable String name){
        return (List<ProductDetailDto>) categoryService.getByName(name);


    }







    @PutMapping("/{id}")
    @Operation(summary = "aktualisirt eine Kategory mit einer bestimmten Id", operationId = "getCategoryById", description = "aktualisirt eine Kategory anhand einer Id")
    public CategoryDetailDto update(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Das ist ein Objekt mit neuen werten welche aktualisirt werden sollen") @RequestBody CategoryUpdateDto category, @Parameter(description = "Die Kategory(id) die aktualisirt werden soll") @PathVariable Long id) {
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


