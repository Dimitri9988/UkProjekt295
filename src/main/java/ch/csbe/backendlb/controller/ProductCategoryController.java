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

    // Verarbeitet Get Anfrage und gibt Infos zu einer Kategorie zurück anhand einer Id
    @GetMapping("{id}")
    public CategoryDetailDto getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    // Verarbeitet Get Anfrage und gibt Produkte einer bestimmten Kategorie zurück
    @GetMapping("{name}/products")
    @Operation(summary = "gibt alle Produkte einer gewissen Kategorie aus", operationId = "getCategoryProducts", description = "es werden alle Produkte ausgegeben welche in der angegebenen Kategorie sind")
    public List<ProductDetailDto> get(@PathVariable String name) {
        return (List<ProductDetailDto>) categoryService.getByName(name);
    }

    // Verarbeitet Put Anfrage und aktualisiert eine Kategorie anhand einer Id
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

    // Verarbeitet Delete Anfrage und löscht eine Kategorie anhand einer Id
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    // Verarbeitet Post Anfrage und erstellt eine neue Kategorie
    @PostMapping("")
    public CategoryDetailDto create(@RequestBody CategoryCreateDto category) {
        return categoryService.create(category);
    }

    // Verarbeitet Get Anfrage und gibt alle Kategorien zurück
    @GetMapping("")
    public List<CategoryDetailDto> get() {
        return categoryService.get();
    }
}
