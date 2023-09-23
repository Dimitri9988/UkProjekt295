package ch.csbe.backendlb.controller;

import ch.csbe.backendlb.resource.category.CategoryService;
import ch.csbe.backendlb.resource.category.categorydto.CategoryCreateDto;
import ch.csbe.backendlb.resource.category.categorydto.CategoryDetailDto;
import ch.csbe.backendlb.resource.category.categorydto.CategoryMapper;
import ch.csbe.backendlb.resource.category.categorydto.CategoryUpdateDto;
import ch.csbe.backendlb.resource.product.productdto.ProductDetailDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CategoryController", description = "Controller für Kategorien")
@RequestMapping("/productscategories")
public class ProductCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;
    // Verarbeited Get Anfrage und gibt Infos zu einer Kategory zurück anhand einer Id
    @GetMapping("{id}")
    public CategoryDetailDto getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
    //  Verarbeited Get Anfrage und gibt Produkte einer bestimten Karegory zurück

    @GetMapping("{name}/products")
    @Operation(summary = "gibt alle Produkte einer gewissen Kategorie aus", operationId = "getCategoryProducts", description = "es werden alle Produkte ausgegeben welche in der angegebenen Kategorie sind")
    public List<ProductDetailDto> get(@PathVariable String name) {
        return (List<ProductDetailDto>) categoryService.getByName(name);
    }

    // Verarbeited Put Anfrage und aktualisirt eine Kategory anhand einer Id
    @PutMapping("{id}")
    @Operation(summary = "aktualisiert eine Kategorie mit einer bestimmten Id", operationId = "getCategoryById", description = "aktualisiert eine Kategorie anhand einer Id")
    public CategoryDetailDto update(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Das ist ein Objekt mit neuen Werten, die aktualisiert werden sollen")
            @RequestBody CategoryUpdateDto category,
            @Parameter(description = "Die Kategorie(id), die aktualisiert werden soll")
            @PathVariable Long id
    ) {
        return categoryService.update(id, category);
    }

    // Verarbeited delete Anfrage und Löscht eine Kategory anhand einer Id
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    // Verarbeited Post Anfrage und Erstelt eine neue Kategory
    @PostMapping("")
    public CategoryDetailDto create(@RequestBody CategoryCreateDto category) {
        return categoryService.create(category);
    }

    // Verarbeited Get Anfrage und gibt alle Produkte zurück
    @GetMapping("")
    public List<CategoryDetailDto> get() {
        return categoryService.get();
    }
}