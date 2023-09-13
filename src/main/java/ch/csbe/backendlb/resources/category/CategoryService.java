package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.category.categorydto.CategoryCreateDto;
import ch.csbe.backendlb.resources.category.categorydto.CategoryDetailDto;
import ch.csbe.backendlb.resources.category.categorydto.CategoryMapper;
import ch.csbe.backendlb.resources.category.categorydto.CategoryUpdateDto;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;


    public List<CategoryDetailDto> get() {

        return categoryRepository.findAll().stream().map(categoryMapper::toDetailDto).collect(Collectors.toList());
    }

    public CategoryDetailDto getById(Long id) {
        CategoryEntities categoryEntities = this.categoryRepository.getById(id);

        CategoryDetailDto categoryDetailDto = categoryMapper.toDetailDto(categoryEntities);
        return categoryDetailDto;
    }

    public CategoryDetailDto create(CategoryCreateDto category) {
        return categoryMapper.toDetailDto(categoryRepository.save(categoryMapper.toEntity(category))) ;
    }

    public CategoryDetailDto update(Long id, CategoryUpdateDto category) {
        Optional<CategoryEntities> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            CategoryEntities existingCategory = categoryOptional.get();
            existingCategory.setName(category.getName());
            existingCategory.setActive(Integer.parseInt(category.getActive()));
            return categoryMapper.toDetailDto(categoryRepository.save(existingCategory));
        }
        return new CategoryDetailDto();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);


    }
}


