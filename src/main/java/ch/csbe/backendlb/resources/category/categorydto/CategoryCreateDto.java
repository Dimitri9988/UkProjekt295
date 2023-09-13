package ch.csbe.backendlb.resources.category.categorydto;

import ch.csbe.backendlb.resources.product.productdto.ProductShowDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryCreateDto {
    @NotNull
    public Long id;
    @NotNull
    public  String active;
    @NotNull
    public String name;
    @NotNull
    private ProductShowDto toDos;
}
