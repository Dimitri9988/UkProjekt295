package ch.csbe.backendlb.resource.category;

import ch.csbe.backendlb.resource.category.categorydto.CategoryUpdateDto;
import ch.csbe.backendlb.resource.category.categorydto.CategoryCreateDto;
import ch.csbe.backendlb.resource.category.categorydto.CategoryDetailDto;
import ch.csbe.backendlb.resource.category.categorydto.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Ist verantwortlich für die Logikt für die Kategoryen
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;

    // GibtListe von CategoryDetailDto Objekten zurück
    public List<CategoryDetailDto> get() {

        return categoryRepository.findAll().stream().map(categoryMapper::toDetailDto).collect(Collectors.toList());
    }

    // Gibt ein CategoryDetailDto Objekt zurück anhand ihrer Id.
    public CategoryDetailDto getById(Long id) {
        CategoryEntities categoryEntities = this.categoryRepository.getById(id);

        CategoryDetailDto categoryDetailDto = categoryMapper.toDetailDto(categoryEntities);
        return categoryDetailDto;
    }
    // Gibt ein CategoryDetailDto Objekt zurück anhand des Namens.
    public CategoryDetailDto getByName(String name) {
        CategoryEntities categoryEntities = this.categoryRepository.findCategoryEntitiesByName(name);

        CategoryDetailDto categoryDetailDto = categoryMapper.toDetailDto(categoryEntities);
        return categoryDetailDto;
    }


    // Erstellt eine neue Kategorie und gibt das Neue CategoryDetailDto zurück.
    public CategoryDetailDto create(CategoryCreateDto category) {
        return categoryMapper.toDetailDto(categoryRepository.save(categoryMapper.toEntity(category))) ;
    }

    // Aktualisiert eine Kategorie anhand ihrer Id und gibt das aktualisierte CategoryDetailDto zurück.
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
    // Löscht eine Kategorie anhand ihrer ID.
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);


    }
}


