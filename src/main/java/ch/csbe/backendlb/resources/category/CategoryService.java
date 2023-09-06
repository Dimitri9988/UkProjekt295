package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;



    public List<CategoryEntities> get() {
        return categoryRepository.findAll();
    }

    public CategoryEntities getById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public CategoryEntities create(CategoryEntities product) {
        return categoryRepository.save(product);
    }

    public CategoryEntities update(Long id, CategoryEntities category) {
        Optional<CategoryEntities> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            CategoryEntities existingCategory = categoryOptional.get();
            existingCategory.setName(category.getName());
            existingCategory.setActive(category.getActive());
            existingCategory.setId(category.getId());
            return categoryRepository.save(existingCategory);
        }
        return new CategoryEntities();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);


    }
}


