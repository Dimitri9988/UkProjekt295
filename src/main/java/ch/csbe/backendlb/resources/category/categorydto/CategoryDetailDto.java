package ch.csbe.backendlb.resources.category.categorydto;

import ch.csbe.backendlb.resources.product.productdto.ProductShowDto;
import jakarta.validation.constraints.NotNull;

public class CategoryDetailDto {
    @NotNull
    public Long id;
    @NotNull
    public  String active;
    @NotNull
    public String name;
    @NotNull
    public ProductShowDto toDos;
}

