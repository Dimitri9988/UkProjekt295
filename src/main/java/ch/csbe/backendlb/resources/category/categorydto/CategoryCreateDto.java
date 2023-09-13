package ch.csbe.backendlb.resources.category.categorydto;

import ch.csbe.backendlb.resources.product.productdto.ProductShowDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema (description = "DTO zum erstellen einer Kategory")
public class CategoryCreateDto {
    @NotNull
    @Schema (description = "einmalige Id zum identifiziren einer Kategory")
    public Long id;
    @NotNull
    @Schema (description = "aktivitäts status einer Kategory")
    public  String active;
    @NotNull
    @Schema (description = "Name einer Kategory")
    public String name;
    @NotNull
    @Schema (description = "Produkte einer Kategory")
    private ProductShowDto toDos;
}
